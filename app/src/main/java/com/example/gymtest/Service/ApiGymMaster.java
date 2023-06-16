package com.example.gymtest.Service;

import com.example.gymtest.Model.Cart;
import com.example.gymtest.Model.ProductModel;
import com.example.gymtest.Model.Products;
import com.example.gymtest.Model.User;
import com.example.gymtest.Model.UserModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiGymMaster {

//    @GET("getsanpham.php")
//    Observable<ProductModel> getsanpham();
//
//    @POST("dangnhap.php")
//    @FormUrlEncoded
//    Observable<UserModel> dangNhap(
//            @Field("admin_email") String email,
//            @Field("admin_password") String pass
//    );
//
    @POST("donhang.php")
    @FormUrlEncoded
    Observable<UserModel> createOder(
            @Field("admin_id") int admin_id
    );


   @GET("sanpham/")
   Call<Products>getallsanpham();

   @GET("dangnhap/")
   Call<User>getsanpham(@Query("admin_email") String admin_email,
                       @Query("admin_password") String admin_password);

   @POST("register")
   Call<Void> saveuser(
           @Query("abc") String abc
   );


   @POST("thanhtoan/")
   Call<Void>thanhtoan(@Query("iduser") int iduser
   );

}
