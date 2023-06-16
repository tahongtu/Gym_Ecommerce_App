package com.example.gymtest.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.gymtest.Activity.CartActivity;
import com.example.gymtest.Model.Products;
import com.example.gymtest.R;
import com.example.gymtest.Utils.Utils;
import com.nex3z.notificationbadge.NotificationBadge;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Fragment_Home extends Fragment {
    View view;
    Toolbar toolbar;
    NotificationBadge badge;
    ImageView imgCart;
    Products products;
    FrameLayout frameLayout;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        init();
        initData();
        return view;
    }

    private void initData() {
//        if (Utils.arrayCart.size() > 0 ){
//            int totalitem = 0;
//            for (int i=0; i<Utils.arrayCart.size(); i++){
//                totalitem = totalitem + Utils.arrayCart.get(i).getAmount();
//            }
//
//            badge.setText(String.valueOf(totalitem));
//        }
//        else {
//            int totalitem = 0;
//            badge.setText(String.valueOf(totalitem));
//        }


    }


    private void init() {
        toolbar = view.findViewById(R.id.toolbar);
        badge = view.findViewById(R.id.menuSL);
        if (Utils.arrayCart == null){
            Utils.arrayCart = new ArrayList<>();
            badge.setText(String.valueOf(0));
        }
        else {
            int totalitem = 0;
            for (int i=0; i<Utils.arrayCart.size(); i++){
                totalitem = totalitem + Utils.arrayCart.get(i).getAmount();
            }
            badge.setText(String.valueOf(totalitem));
        }


        imgCart = view.findViewById(R.id.carts);
        imgCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cart = new Intent(getActivity(), CartActivity.class);
                startActivity(cart);
            }
        });
        frameLayout = view.findViewById(R.id.framegiohang);
//        frameLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent cart = new Intent(getActivity(), CartActivity.class);
//                startActivity(cart);
//            }
//        });

    }

    @Override
    public void onResume() {
        super.onResume();
        int totalitem = 0;
        for (int i=0; i<Utils.arrayCart.size(); i++){
            totalitem = totalitem + Utils.arrayCart.get(i).getAmount();
        }
        badge.setText(String.valueOf(totalitem));
    }
}
