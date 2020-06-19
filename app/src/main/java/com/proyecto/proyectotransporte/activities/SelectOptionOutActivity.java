package com.proyecto.proyectotransporte.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.proyecto.proyectotransporte.R;
import com.proyecto.proyectotransporte.activities.client.activity_register;
import com.proyecto.proyectotransporte.activities.driver.RegisteDriverActivity;
import com.proyecto.proyectotransporte.includes.Mytoolbar;

public class SelectOptionOutActivity extends AppCompatActivity {


    Button mButtonGoToLogin;
    Button mButtonGoToRegister;
    SharedPreferences mPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_option_out);
        Mytoolbar.show(this,"Registrar usuario", true);


        mButtonGoToLogin = findViewById(R.id.btnGoToLogin);
        mButtonGoToRegister = findViewById(R.id.btnGoToRegister);
        mButtonGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLogin();
            }
        });
        mButtonGoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRegister();
            }
        });
        mPref = getApplicationContext().getSharedPreferences("typeUser", MODE_PRIVATE);
    }
    public void goToLogin(){
        Intent intent = new Intent(SelectOptionOutActivity.this, activity_login.class);
        startActivity(intent);
    }
    public void goToRegister(){
        String typeUser = mPref.getString("user", "");
        if (typeUser.equals("client")){
            Intent intent = new Intent(SelectOptionOutActivity.this, activity_register.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(SelectOptionOutActivity.this,  RegisteDriverActivity.class);
            startActivity(intent);
        }

    }
}
