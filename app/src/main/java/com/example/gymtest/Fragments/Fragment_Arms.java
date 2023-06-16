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

public class Fragment_Arms extends Fragment {
    View view;
    HorizontalScrollView horizontalScrollView;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_arms, container, false);

        horizontalScrollView = view.findViewById(R.id.horizontalScrollView);
        arms();
        return view;
    }

    private void arms() {
        final ArrayList<String> arrayArm = new ArrayList<>();
        arrayArm.add("https://cdn-ami-drupal.heartyhosting.com/sites/muscleandfitness.com/files/styles/full_node_image_1090x614/public/media/dumbbell-biceps-curl-arm-exercise.jpg?itok=HmOXoTAx");
        arrayArm.add("https://www.muscleandfitness.com/wp-content/uploads/2018/02/Bodybuilder-Dumbbell-Curl-Biceps-1109.jpg?w=1109&h=614&crop=1");
        arrayArm.add("https://sm.askmen.com/t/askmen_me/article/b/bodybuilde/bodybuilders-arm-workout_jc13.1200.jpg");
        arrayArm.add("https://www.yourworkoutbook.com/wp-content/uploads/2022/06/Cable-Machine-Arm-Exercises-and-Workout.jpg");
        arrayArm.add("http://www.precisionpointtraining.com/wp-content/uploads/2016/09/Fotolia_113701659_Subscription_Monthly_M.jpg");

        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(580, 250);
        layout.setMargins(10, 20, 10, 30);

        for (int i=0; i<arrayArm.size(); i++){
            CardView cardView = new CardView(getActivity());
            cardView.setRadius(10);
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(getActivity()).load(arrayArm.get(i)).into(imageView);

            cardView.setLayoutParams(layout);
            cardView.addView(imageView);
            linearLayout.addView(cardView);
        }
        horizontalScrollView.addView(linearLayout);

    }
}
