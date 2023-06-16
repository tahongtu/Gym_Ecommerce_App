package com.example.gymtest.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.gymtest.R;

import org.jetbrains.annotations.NotNull;

public class Fragment_Today extends Fragment {
    View view;
    ImageView imgToday;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_today, container, false);

        anhxa();

        return view;
    }

    private void anhxa() {
        imgToday = view.findViewById(R.id.imgToday);
        Glide.with(getContext()).load("https://i5.walmartimages.com/asr/9a48e683-1fa4-4bf1-be88-be67c65259d8.5eab46275d2d0a3770e281948f8b7f4b.jpeg").into(imgToday);
        imgToday.setScaleType(ImageView.ScaleType.FIT_XY);
    }
}
