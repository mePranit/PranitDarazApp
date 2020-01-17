package com.example.pranitdarazapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pranitdarazapp.Retrofit.API;
import com.example.pranitdarazapp.Retrofit.dbconnect;
import com.example.pranitdarazapp.R;
import com.example.pranitdarazapp.modal.Users;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {
  Button btnReg;
  EditText etUserName,etEmail,etPassword;
    private Users users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnReg=findViewById(R.id.btnReg);
        etUserName=findViewById(R.id.etUsername);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
               // Toast.makeText(RegisterActivity.this, "Hello", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void register() {

        final String userName = etUserName.getText().toString();
        final String userEmail = etEmail.getText().toString();
        final String userPassword = etPassword.getText().toString();

        Users users=new Users(userName,userEmail,userPassword);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(dbconnect.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api=retrofit.create(API.class);
        Call<Void> voidCall=api.registerUser(users);

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(RegisterActivity.this, "Success", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), VerificationPage.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}
