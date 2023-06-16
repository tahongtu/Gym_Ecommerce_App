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

import com.bumptech.glide.Glide;
import com.example.gymtest.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class Fragment_ShopBanner extends Fragment {
    View view;
    ViewFlipper viewFlipper;
    CircleIndicator circleIndicator;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shopbanner, container, false);

        anhxa();
        ActionViewFlipper();
        return view;
    }

    private void ActionViewFlipper() {
        List<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://3.bp.blogspot.com/-YpZ3fVowzmk/XNPZARfQ19I/AAAAAAAAA48/403870Ig0_wGlmCqkgCd7Bwdjq0YRK5CwCEwYBhgL/s1600/gym-banner-1.jpg");
        mangquangcao.add("https://fm.nutritionwarehouse.com.au/media/wysiwyg/dymatize-elite-whey-banner.jpg");
        mangquangcao.add("https://d1h5acvpyfsue8.cloudfront.net/ultra-bcaa-mob-banner1.jpg");
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

    private void anhxa() {
        viewFlipper = view.findViewById(R.id.viewFlipperShop);
        circleIndicator = view.findViewById(R.id.circleIndicatorShop);
    }
}
