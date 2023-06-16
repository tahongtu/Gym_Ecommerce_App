package com.example.gymtest.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.gymtest.R;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Fragment_ABS extends Fragment {
    View view;
    HorizontalScrollView horizontalScrollView;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_abs, container, false);
        horizontalScrollView = view.findViewById(R.id.horizontalScrollView);

        ABS();

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void ABS() {
        final ArrayList<String> arrayABS = new ArrayList<>();
        arrayABS.add("https://i.pinimg.com/originals/6f/9e/f8/6f9ef8cfcf72ba0c2ee28407e27e8fc9.jpg");
        arrayABS.add("https://img.freepik.com/free-photo/fit-man-training-abs-muscles-gym-dark-background_174475-2507.jpg?size=626&ext=jpg");
        arrayABS.add("https://besthqwallpapers.com/Uploads/23-3-2018/45386/thumb2-plank-exercise-front-hold-bodybuilding-bar-sports-exercise.jpg");
        arrayABS.add("https://abmachinesguide.com/wp-content/uploads/2017/11/what-makes-a-good-ab-workout.jpg");
        arrayABS.add("https://1.bp.blogspot.com/-7EqdMN2vNUE/W4f8uqq5v8I/AAAAAAAAAPQ/PYTEkYMsyHQyb-efsh2rIJgKfUgR2pruQCLcBGAs/s640/abs-la-gi.jpg");

        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(580, 250);
        layout.setMargins(10, 20, 10, 30);

        for (int i=0; i<arrayABS.size(); i++){
            CardView cardView = new CardView(getActivity());
            cardView.setRadius(10);
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(getActivity()).load(arrayABS.get(i)).into(imageView);

            cardView.setLayoutParams(layout);
            cardView.addView(imageView);
            linearLayout.addView(cardView);
        }
        horizontalScrollView.addView(linearLayout);
    }
}
