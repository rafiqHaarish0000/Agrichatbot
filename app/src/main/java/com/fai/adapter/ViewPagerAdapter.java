package com.fai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.fai.agribot.R;


public class ViewPagerAdapter extends PagerAdapter {

    Context context;

    int images[] = {

            R.drawable.bg_img_1,
            R.drawable.bg_img_2,
            R.drawable.bg_img_3,

    };

    int headings[] = {

            R.string.fist_indicatior_txt,
            R.string.second_indicatior_txt,
            R.string.third_indicator_txt,
    };


    public ViewPagerAdapter(Context context){

        this.context = context;

    }

    @Override
    public int getCount() {
        return  headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout,container,false);

        ImageView slidetitleimage = (ImageView) view.findViewById(R.id.sliderImage);
        TextView slideHeading = (TextView) view.findViewById(R.id.bannerTxt);

        slidetitleimage.setImageResource(images[position]);
        slideHeading.setText(headings[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);

    }
}
