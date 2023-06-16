package com.example.gymtest.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.gymtest.R;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class Fragment_Banner extends Fragment {
    View view;
    ViewFlipper viewFlipper;
    CircleIndicator circleIndicator;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner, container, false);
        anhxa();
        ActionViewFlipper();
        return view;
    }

    private void ActionViewFlipper() {
        List<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://s3.envato.com/files/221476662/BEE-1931-Fitness%20Banners_01_Preview4.jpg");
        mangquangcao.add("https://www.geeks5g.com/wp-content/uploads/2021/04/GYM-Banner-scaled.jpg");
        mangquangcao.add("https://3.bp.blogspot.com/-YpZ3fVowzmk/XNPZARfQ19I/AAAAAAAAA48/403870Ig0_wGlmCqkgCd7Bwdjq0YRK5CwCEwYBhgL/s1600/gym-banner-1.jpg");
        for (int i=0; i<mangquangcao.size(); i++)
        {
            ImageView imageView = new ImageView(this.getContext());
            Glide.with(getContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
//            circleIndicator.setViewPager(viewFlipper);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        Animation slide_in = AnimationUtils.loadAnimation(this.getContext(), R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(this.getContext(), R.anim.slide_out_right);
    }

    public void anhxa(){
        viewFlipper = view.findViewById(R.id.viewFlipper);
        circleIndicator = view.findViewById(R.id.circleIndicator);
    }
}
