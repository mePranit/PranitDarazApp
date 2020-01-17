package com.example.pranitdarazapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pranitdarazapp.R;


public class VerificationPage extends AppCompatActivity {
   EditText vcode;
   Button btnvSubmit;
    private static int SPLASH_TIME_OUT = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_page);

        vcode=findViewById(R.id.vcode);
        btnvSubmit=findViewById(R.id.btnvSubmit);

        btnvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
                finish();
            }
        });

        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          vcode.setText("pranit");
                                          btnvSubmit.setVisibility(View.VISIBLE);;

                                      }
                                  }, SPLASH_TIME_OUT
        );


    }
}
