package com.example.gymtest.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gymtest.Model.User;
import com.example.gymtest.Model.UserModel;
import com.example.gymtest.R;
import com.example.gymtest.Service.ApiGymMaster;
import com.example.gymtest.Utils.Utils;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText txtEmail, txtPass;
    Button btnLogin;
    TextView txtRegis;

    ApiGymMaster apiGymMaster;
    CompositeDisposable compositeDisposable = new CompositeDisposable();;
       public static int iduser ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        init();
        initControl();
    }

    private void initControl() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_email = txtEmail.getText().toString().trim();
                String str_pass = txtPass.getText().toString().trim();

                if (TextUtils.isEmpty(str_email)){
                    Toast.makeText(LoginActivity.this, "Bạn chưa nhập Email", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(str_pass)){
                    Toast.makeText(LoginActivity.this, "Bạn chưa nhập Pass", Toast.LENGTH_SHORT).show();
                }else {
//                    compositeDisposable.add(apiGymMaster.dangNhap(str_email, str_pass)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(
//                            userModel -> {
//                                if (userModel.isSuccess()){
//                                    Utils.user_current = userModel.getResult().get(0);
//                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                                else {
//                                    Toast.makeText(LoginActivity.this, "Mật khẩu hoặc tên đăng nhập không chính xác!", Toast.LENGTH_SHORT).show();
//                                }
//                            },
//                            throwable -> {
//                                Toast.makeText(LoginActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//                    ));

                    apiGymMaster = Utils.getService();
                    Call<Void> call = apiGymMaster.saveuser(str_email);
                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
//                            if(response.isSuccessful()){
//
//                                Utils.user_current = response.body().getUser().get(0);
//                                for (User item:response.body().getUser()){
//                                    iduser = item.getAdmin_id();
//                                }
//
//                                Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                                    startActivity(intent);
//                                    finish();
//                            }else{
//                                Toast.makeText(LoginActivity.this, "throwable.getMessage()", Toast.LENGTH_SHORT).show();
//                            }

                            if (response.code() == 404){
                                Toast.makeText(LoginActivity.this, "Okeke", Toast.LENGTH_SHORT).show();
                            } else if (response.code() == 200) {
                                Toast.makeText(LoginActivity.this, "faill", Toast.LENGTH_SHORT).show();
                            }
                        }


                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, "423424"+t, Toast.LENGTH_SHORT).show();
                        }
                    });


                }
            }
        });
    }

    private void init() {


        txtEmail = findViewById(R.id.email);
        txtPass = findViewById(R.id.pass);
        btnLogin = findViewById(R.id.btnLogin);
        txtRegis = findViewById(R.id.txtRegister);
    }



    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}