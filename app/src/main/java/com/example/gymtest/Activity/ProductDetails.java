package com.example.gymtest.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gymtest.Fragments.Fragment_Home;
import com.example.gymtest.Model.Cart;
import com.example.gymtest.Model.Products;
import com.example.gymtest.R;
import com.example.gymtest.Utils.Utils;
import com.nex3z.notificationbadge.NotificationBadge;

import java.text.DecimalFormat;

public class ProductDetails extends AppCompatActivity {
    TextView txtNameProduct, txtPriceProduct, txtDetails, txtSL;
    Button btnAddCart;
    ImageButton btntang, btngiam;
    ImageView imgProduct, imgCart;
//    Spinner spinner;
    Toolbar toolbar;
    Products products;
    NotificationBadge badge;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details2);
        initView();
        ActionToolbar();
        initData();
        initControl();
    }

    private void initControl() {
        btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCArt();
            }
        });
    }

    private void addCArt() {
        if (Utils.arrayCart.size() > 0){
            boolean flag = false;
            int amount = Integer.parseInt(txtSL.getText().toString());
            for (int i=0; i< Utils.arrayCart.size(); i++){
                if (Utils.arrayCart.get(i).getIdProduct() == products.getId_sanpham()){
                    Utils.arrayCart.get(i).setAmount(amount + Utils.arrayCart.get(i).getAmount());
//                    long price = Long.parseLong(products.getGia()) * Utils.arrayCart.get(i).getAmount();
                    Utils.arrayCart.get(i).setPriceProduct(Long.parseLong(products.getGia()));
                    flag = true;

                }
            }
            if (flag == false){
//                long price = Long.parseLong(products.getGia()) * amount;
                Cart cart = new Cart();
                cart.setPriceProduct(Long.parseLong(products.getGia()));
                cart.setAmount(amount);
                cart.setIdProduct(products.getId_sanpham());
                cart.setImageProduct(products.getImage());
                cart.setNameProduct(products.getTensanpham());
                Utils.arrayCart.add(cart);
            }


        }else{

            int amount = Integer.parseInt(txtSL.getText().toString());
//            long price = Long.parseLong(products.getGia()) * amount;
            Cart cart = new Cart();
            cart.setPriceProduct(Long.parseLong(products.getGia()));
            cart.setAmount(amount);
            cart.setIdProduct(products.getId_sanpham());
            cart.setImageProduct(products.getImage());
            cart.setNameProduct(products.getTensanpham());
            Utils.arrayCart.add(cart);
        }
        int totalitem = 0;
        for (int i=0; i<Utils.arrayCart.size(); i++){
            totalitem = totalitem + Utils.arrayCart.get(i).getAmount();
        }
        badge.setText(String.valueOf(totalitem));
    }

    private void initData() {
        products = (Products) getIntent().getSerializableExtra("details");
        txtNameProduct.setText(products.getTensanpham());
        //
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        txtPriceProduct.setText("Price: "+decimalFormat.format(Double.parseDouble(products.getGia())) +" $");
        txtDetails.setText(products.getThongtin());
        Glide.with(getApplicationContext()).load(Utils.linkimg + products.getImage()).into(imgProduct);

        //spinner
//        Integer[] so = new Integer[]{1,2,3,4,5,6,7,8,9};
//        ArrayAdapter<Integer> adapterSpin = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, so);
//        spinner.setAdapter(adapterSpin);
    }


    private void initView() {
        txtNameProduct = findViewById(R.id.txtNameProduct);
        txtPriceProduct = findViewById(R.id.txtPriceProduct);
        txtDetails = findViewById(R.id.txtDetails);
        imgProduct = findViewById(R.id.imgProduct);
        //spinner = findViewById(R.id.spinner);
        btnAddCart = findViewById(R.id.btnAddCart);
        toolbar = findViewById(R.id.toolbar);
//        imgCart = findViewById(R.id.carts);
//        imgCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent cart = new Intent(getApplicationContext(), CartActivity.class);
//                startActivity(cart);
//            }
//        });
//        imgCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment_Home fragment_home = new Fragment_Home();
//                getSupportFragmentManager().beginTransaction().add(R.id.productDetail, fragment_home).commit();
//            }
//        });



        badge = findViewById(R.id.menuSL);
        if (Utils.arrayCart.size() > 0 ){
            int totalitem = 0;
            for (int i=0; i<Utils.arrayCart.size(); i++){
                totalitem = totalitem + Utils.arrayCart.get(i).getAmount();
            }

            badge.setText(String.valueOf(totalitem));
        }
        else {
            int totalitem = 0;
            badge.setText(String.valueOf(totalitem));
        }


        FrameLayout frameLayoutCart = findViewById(R.id.framegiohang);
        frameLayoutCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cart = new Intent(getApplicationContext(), CartActivity.class);
                startActivity(cart);
            }
        });




        btngiam = findViewById(R.id.btngiam);
        btngiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sl = Integer.parseInt(txtSL.getText().toString());
                if (sl == 1){
                    Toast.makeText(ProductDetails.this, "Minimum limit has been reached", Toast.LENGTH_SHORT).show();
                }
                else{
                    sl = sl-1;
                    txtSL.setText(String.valueOf(sl));
                }

            }
        });

        btntang = findViewById(R.id.btntang);
        btntang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sl = Integer.parseInt(txtSL.getText().toString());
                sl = sl+1;
                txtSL.setText(String.valueOf(sl));
            }
        });

        txtSL = findViewById(R.id.txtSL);
        txtSL.setText("1");
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (Utils.arrayCart.size() > 0 ){
            int totalitem = 0;
            for (int i=0; i<Utils.arrayCart.size(); i++){
                totalitem = totalitem + Utils.arrayCart.get(i).getAmount();
            }

            badge.setText(String.valueOf(totalitem));
        }
        else {
            int totalitem = 0;
            badge.setText(String.valueOf(totalitem));
        }

    }
}