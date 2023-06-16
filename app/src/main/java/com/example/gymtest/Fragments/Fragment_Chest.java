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

public class Fragment_Chest extends Fragment {
    View view;
    HorizontalScrollView horizontalScrollView;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chest, container, false);
        horizontalScrollView = view.findViewById(R.id.horizontalScrollView);

        chest();

        return view;
    }

    private void chest() {
        final ArrayList<String> arrayChest = new ArrayList<>();
        arrayChest.add("https://www.bodybuilding.com/images/2016/june/5-chest-workouts-for-mass-v2-1.jpg");
        arrayChest.add("https://homegymr.com/wp-content/uploads/2016/07/Dumbbell-Bench-Press.jpg");
        arrayChest.add("https://cdn-ami-drupal.heartyhosting.com/sites/muscleandfitness.com/files/styles/full_node_image_1090x614/public/media/trx-flye-chest_0.jpg?itok=K9j_0drv");
        arrayChest.add("https://cdn.shopify.com/s/files/1/0133/8576/0826/articles/5131-9-best-chest_1800x1013.jpg?v=1532444257");
        arrayChest.add("https://www.muscleandfitness.com/wp-content/uploads/2015/10/cable-crossover-content-chest-pec.jpg?w=3200&quality=86&strip=all");

        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(580, 250);
        layout.setMargins(10, 20, 10, 30);

        for (int i=0; i<arrayChest.size(); i++){
            CardView cardView = new CardView(getActivity());
            cardView.setRadius(10);
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(getActivity()).load(arrayChest.get(i)).into(imageView);

            cardView.setLayoutParams(layout);
            cardView.addView(imageView);
            linearLayout.addView(cardView);
        }
        horizontalScrollView.addView(linearLayout);
    }
}
