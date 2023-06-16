package com.example.gymtest.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gymtest.Adapters.ProductAdapter;
import com.example.gymtest.Model.Cart;
import com.example.gymtest.Model.Products;
import com.example.gymtest.R;
import com.example.gymtest.Service.ApiGymMaster;
import com.example.gymtest.Utils.Utils;
import com.google.gson.Gson;

import java.text.DecimalFormat;
import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThanhToanActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView paytotal, txtname, txtsdt, txtmail;
    EditText edtDiachi;
    Button btnDathang;

    long totalproduct;

    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiGymMaster apiGymMaster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);

        init();
        initControl();
        countsp();
    }

    private void countsp() {
        totalproduct = 0;
        for (int i=0; i<Utils.arrayCart.size(); i++){
            totalproduct = totalproduct + (Utils.arrayCart.get(i).getPriceProduct() * Utils.arrayCart.get(i).getAmount());
        }
    }

    private void initControl() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        long tongtien = getIntent().getLongExtra("tongtien", 0);
        paytotal.setText(decimalFormat.format(tongtien) + "$");
//        txtname.setText(Utils.user_current.getAdmin_name());
//        txtmail.setText(Utils.user_current.getGmail());
//        txtsdt.setText(Utils.user_current.getSdt());


        btnDathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_diachi = edtDiachi.getText().toString().trim();
                if (TextUtils.isEmpty(str_diachi)){
                    Toast.makeText(ThanhToanActivity.this, "Bạn chưa nhập địa chỉ", Toast.LENGTH_SHORT).show();
                }
                else {
                    //post data
//                    Log.d("Test", new Gson().toJson(Utils.arrayCart));
//
                    int id = 271;
//                    int id_product = Utils.arrayCart.get(0).getIdProduct();
//                    int soluong = Utils.arrayCart.get(0).getAmount();
//                    long gia = Utils.arrayCart.get(0).getPriceProduct();
                    compositeDisposable.add(apiGymMaster.createOder(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            userModel -> {
                                Toast.makeText(ThanhToanActivity.this, "Dat hang thanh cong", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                finish();
                            },
                            throwable -> {

                                Toast.makeText(ThanhToanActivity.this, "Dat hang thanh cong", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                    ));






//                 ArrayList<Cart> carts = new ArrayList<>(Utils.arrayCart);
//                apiGymMaster = Utils.getService();
//                Call<Void> call = apiGymMaster.thanhtoan(LoginActivity.iduser);
//                call.enqueue(new Callback<Void>() {
//                    @Override
//                    public void onResponse(Call<Void> call, Response<Void> response) {
//                        if(response.isSuccessful()){
//
//
//                            Toast.makeText(ThanhToanActivity.this, "thanhcong", Toast.LENGTH_SHORT).show();
//
//                        }else{
//                            Toast.makeText(ThanhToanActivity.this, "thatbai", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Void> call, Throwable t) {
//                        Toast.makeText(ThanhToanActivity.this, "423424"+t, Toast.LENGTH_SHORT).show();
//                    }
//                });


            }

            }

        });


    }

    private void init() {
        apiGymMaster = Utils.getService1();

        toolbar = findViewById(R.id.toolbar);
        paytotal = findViewById(R.id.paytotal);
        txtname = findViewById(R.id.txtname);
        txtsdt = findViewById(R.id.txtsdt);
        txtmail = findViewById(R.id.txtmail);
        edtDiachi = findViewById(R.id.edtDiachi);
        btnDathang = findViewById(R.id.btnDathang);

    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}