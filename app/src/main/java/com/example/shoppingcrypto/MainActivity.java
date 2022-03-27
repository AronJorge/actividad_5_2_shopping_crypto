package com.example.shoppingcrypto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.shoppingcrypto.databinding.ActivityMainBinding;
import com.example.shoppingcrypto.login.LoginActivity;
import com.example.shoppingcrypto.register.RegisterActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(this);
        binding.btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (binding.btnLogin == view) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (binding.btnRegister == view) {
            startActivity(new Intent(this, RegisterActivity.class));
        }
    }
}