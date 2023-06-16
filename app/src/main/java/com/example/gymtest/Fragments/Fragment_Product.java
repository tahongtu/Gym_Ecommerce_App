package com.example.gymtest.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymtest.Activity.LoginActivity;
import com.example.gymtest.Activity.MainActivity;
import com.example.gymtest.Adapters.ProductAdapter;
import com.example.gymtest.Model.ProductModel;
import com.example.gymtest.Model.Products;
import com.example.gymtest.Model.User;
import com.example.gymtest.R;
import com.example.gymtest.Service.ApiGymMaster;
import com.example.gymtest.Service.RetrofitClient;
import com.example.gymtest.Utils.Utils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Product extends Fragment {
    View view;
    RecyclerView recyclerView;
    ProductAdapter productAdapter;
    ArrayList<Products> arrayProduct;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiGymMaster apiGymMaster;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_product, container, false);




        anhxa();
        getproduct();

        return view;
    }

    private void getproduct() {
//        apiGymMaster = Utils.getService();
//        compositeDisposable.add(apiGymMaster.getsanpham()
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe(
//                ProductModel -> {
//                    if (ProductModel.isSuccess()){
//                        Toast.makeText(getContext(), ProductModel.getResult().get(0).getTensanpham(), Toast.LENGTH_LONG).show();
//                        Toast.makeText(getContext(), ProductModel.getResult().get(0).getImage(), Toast.LENGTH_LONG).show();
//                        Toast.makeText(getContext(), ProductModel.getResult().get(0).getThongtin(), Toast.LENGTH_LONG).show();
//                        Toast.makeText(getContext(), ProductModel.getResult().get(0).getGia(), Toast.LENGTH_LONG).show();
//
//                       arrayProduct = ProductModel.getResult();
//                       productAdapter = new ProductAdapter(getContext(), arrayProduct);
//                       recyclerView.setAdapter(productAdapter);
//
//                    }
//                },
//                throwable -> {
//                    Toast.makeText(getContext(), "No Internet Connected"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//        ));

        apiGymMaster = Utils.getService();
        Call<Products> call = apiGymMaster.getallsanpham();
        call.enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {
                if(response.isSuccessful()){


                    ArrayList<Products> arrayProduct = response.body().getProducts();
                       productAdapter = new ProductAdapter(getContext(), arrayProduct);
                       recyclerView.setAdapter(productAdapter);
                      productAdapter.notifyDataSetChanged();




                }else{
                    Toast.makeText(getContext(), "throwable.getMessage()", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Products> call, Throwable t) {
                Toast.makeText(getContext(), "423424"+t, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void anhxa() {
        recyclerView = view.findViewById(R.id.recycleViewProduct);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this.getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        arrayProduct = new ArrayList<>();

        if (Utils.arrayCart == null){
            Utils.arrayCart = new ArrayList<>();

        }
    }
}
