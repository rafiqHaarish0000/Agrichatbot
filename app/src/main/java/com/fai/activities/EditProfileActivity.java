package com.fai.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.fai.agribot.R;
import com.fai.agribot.databinding.ActivityEditProfileBinding;

import java.util.ArrayList;
import java.util.List;

public class EditProfileActivity extends AppCompatActivity {
    ActivityEditProfileBinding editProfileBinding;
    private List<String> genderList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editProfileBinding = DataBindingUtil.setContentView(EditProfileActivity.this,R.layout.activity_edit_profile);
        setContentView(editProfileBinding.getRoot());
        genderList = new ArrayList<>();
        genderList.add("Male");
        genderList.add("Female");
        editProfileBinding.genderSpinner.setItem(genderList);

    }

}