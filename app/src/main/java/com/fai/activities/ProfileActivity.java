package com.fai.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fai.agribot.R;
import com.fai.agribot.databinding.ActivityProfileBinding;
import com.fai.utils.PermissionUtils;

public class ProfileActivity extends AppCompatActivity {
    ActivityProfileBinding profileBinding;
    int SELECT_PICTURE = 200;
    String txtName = null;
    int valuePic = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profileBinding = DataBindingUtil.setContentView(ProfileActivity.this, R.layout.activity_profile);
        setContentView(profileBinding.getRoot());

        txtName = profileBinding.txtName.getText().toString();

        profileBinding.profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (PermissionUtils.checkPermission(ProfileActivity.this)) {
                    imageChooser();
                } else {
                    PermissionUtils.requestPermission(ProfileActivity.this);
                }
            }
        });

        profileBinding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(profileBinding.txtName.getText().length() == 0){
                        profileBinding.txtName.setError("Please do not empty field");
                }else if(valuePic == 0){
                    Toast.makeText(ProfileActivity.this, "Please upload your profile picture", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
                    intent.putExtra("name", profileBinding.txtName.getText().toString());
                    startActivity(intent);
                    finish();
                }

            }
        });

        if (profileBinding.editIcon.getVisibility() == View.VISIBLE) {
            profileBinding.editIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageChooser();
                }
            });
        }
//        btnsave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

    }

    void imageChooser() {

        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    profileBinding.profileImage.setImageURI(selectedImageUri);
                    valuePic = 1;
                    profileBinding.editIcon.setVisibility(View.VISIBLE);
                }else{
                    valuePic = 0;
                }
            }
        }
    }


}