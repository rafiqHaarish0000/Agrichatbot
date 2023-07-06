package com.fai.agribot;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import com.fai.agribot.databinding.ActivityProfileBinding;
import com.fai.utils.PermissionUtils;

public class ProfileActivity extends AppCompatActivity {
ActivityProfileBinding profileBinding;
    int SELECT_PICTURE = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profileBinding = DataBindingUtil.setContentView(ProfileActivity.this,R.layout.activity_profile);
        setContentView(profileBinding.getRoot());

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

        if(profileBinding.editIcon.getVisibility()==View.VISIBLE){
            profileBinding.editIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageChooser();
                }
            });
        }

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
                    profileBinding.editIcon.setVisibility(View.VISIBLE);

                }
            }
        }
    }


}