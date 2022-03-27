package com.example.shoppingcrypto.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shoppingcrypto.MainActivity;
import com.example.shoppingcrypto.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        binding.btnLogout.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
    }

}
