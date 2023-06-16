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

public class Fragment_Back extends Fragment {
    View view;
    HorizontalScrollView horizontalScrollView;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_back, container, false);
        horizontalScrollView = view.findViewById(R.id.horizontalScrollView);

        back();

        return view;
    }

    private void back() {
        final ArrayList<String> arrayBack = new ArrayList<>();
        arrayBack.add("https://weighttraining.guide/wp-content/uploads/2020/06/Muscle-2.png");
        arrayBack.add("https://cdn-ami-drupal.heartyhosting.com/sites/muscleandfitness.com/files/media/1109-one-arm-dumbbell-row-back.jpg");
        arrayBack.add("https://www.bodybuilding.com/images/2017/august/the-5-best-back-machines-for-maximum-growth-3-700xh.jpg");
        arrayBack.add("https://musculacaoonline.com.br/wp-content/uploads/2013/12/Eleva%C3%A7%C3%A3o-na-barra-fixa-conhe%C3%A7a-o-melhor-exerc%C3%ADcio-para-as-costas-1024x683.jpg");
        arrayBack.add("https://thehust.com/wp-content/uploads/2018/05/610576810_XS.jpg");

        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(580, 250);
        layout.setMargins(10, 20, 10, 30);

        for (int i=0; i<arrayBack.size(); i++){
            CardView cardView = new CardView(getActivity());
            cardView.setRadius(10);
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(getActivity()).load(arrayBack.get(i)).into(imageView);

            cardView.setLayoutParams(layout);
            cardView.addView(imageView);
            linearLayout.addView(cardView);
        }
        horizontalScrollView.addView(linearLayout);
    }
}
