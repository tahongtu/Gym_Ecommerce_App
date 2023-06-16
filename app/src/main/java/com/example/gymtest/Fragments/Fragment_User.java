package com.example.gymtest.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.gymtest.Activity.LoginActivity;
import com.example.gymtest.Model.User;
import com.example.gymtest.R;
import com.example.gymtest.Utils.Utils;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Fragment_User extends Fragment {
    View view;
    TextView username, gmail, phonenb, sexuser;
    ImageView imgUser;
    Button btnDangxuat;


    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user, container, false);
        init();
        initControl();
        initData();
        return view;
    }

    private void initData() {
//        username.setText(Utils.user_current.getAdmin_name());
//        gmail.setText(Utils.user_current.getGmail());
//        phonenb.setText(Utils.user_current.getSdt());
//        sexuser.setText(Utils.user_current.getGioitinh());
//
//        Glide.with(getContext()).load(Utils.linkimg + Utils.user_current.getImage()).into(imgUser);

    }

    private void initControl() {
        btnDangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        username = view.findViewById(R.id.userName);
        gmail = view.findViewById(R.id.gmailUser);
        phonenb = view.findViewById(R.id.phoneUser);
        sexuser = view.findViewById(R.id.sexUser);
        imgUser = view.findViewById(R.id.imgUser);
        btnDangxuat = view.findViewById(R.id.btnDangxuat);
    }
}
