package com.fai.agribot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageSlider imageSlider = findViewById(R.id.image_slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.bg_img_1,ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.bg_img_2,ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.bg_img_3,ScaleTypes.CENTER_CROP));
        imageSlider.setImageList(slideModels,ScaleTypes.CENTER_CROP);
    }
}