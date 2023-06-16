package com.example.gymtest.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gymtest.Adapters.CartAdapter;
import com.example.gymtest.Model.EventBus.MoneyTotalEvent;
import com.example.gymtest.R;
import com.example.gymtest.Utils.Utils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.DecimalFormat;

public class CartActivity extends AppCompatActivity {
    TextView emptyCart, total;
    Toolbar toolbar;
    RecyclerView recyclerView;
    Button btnBuy;
    CartAdapter cartAdapter;
    long totalproduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        init();
        initControl();
        totalMoney();
    }

    private void totalMoney() {
        totalproduct = 0;
        for (int i=0; i<Utils.arrayCart.size(); i++){
            totalproduct = totalproduct + (Utils.arrayCart.get(i).getPriceProduct() * Utils.arrayCart.get(i).getAmount());
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        total.setText(decimalFormat.format(totalproduct) + "$");
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

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if (Utils.arrayCart.size() == 0){
            emptyCart.setVisibility(View.VISIBLE);
        }
        else{
            cartAdapter = new CartAdapter(getApplicationContext(), Utils.arrayCart);
            recyclerView.setAdapter(cartAdapter);
        }


        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThanhToanActivity.class);
                intent.putExtra("tongtien", totalproduct);

                startActivity(intent);
            }
        });


    }

    private void init() {
        emptyCart = findViewById(R.id.txtEmptyCart);
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recycleviewCart);
        total = findViewById(R.id.txttotal);
        btnBuy = findViewById(R.id.btnBuy);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void eventMoneyTotal(MoneyTotalEvent event){
        if (event !=null){
            totalMoney();
        }
    }
}