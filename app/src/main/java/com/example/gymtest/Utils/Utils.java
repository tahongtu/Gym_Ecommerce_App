package com.example.gymtest.Utils;

import com.example.gymtest.Model.Cart;
import com.example.gymtest.Model.User;
import com.example.gymtest.Service.ApiGymMaster;
import com.example.gymtest.Service.RetrofitClient;

import java.util.List;

public class Utils {
    public  static  final String linkimg = "http://192.168.43.235:8080/gymtext/public/uploads/";
    public static final String BASE_URL = "http://192.168.1.9:8000/api/";
    public static final String BASE_URL1 = "http://192.168.43.235:8080/GymMaster/";

    public static ApiGymMaster getService(){
        return RetrofitClient.getInstance(BASE_URL).create(ApiGymMaster.class);
    }
    public static ApiGymMaster getService1(){
        return RetrofitClient.getInstance(BASE_URL1).create(ApiGymMaster.class);
    }

    public static List<Cart> arrayCart;
    public static User user_current = new User();
}
