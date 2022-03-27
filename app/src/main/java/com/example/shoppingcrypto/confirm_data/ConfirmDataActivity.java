package com.example.shoppingcrypto.confirm_data;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shoppingcrypto.databinding.ActivityRegisterSuccessBinding;
import com.example.shoppingcrypto.home.HomeActivity;
import com.example.shoppingcrypto.model.LiveData;

public class ConfirmDataActivity extends AppCompatActivity {
    private ActivityRegisterSuccessBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterSuccessBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        startUI();
    }

    private void startUI() {
        binding.txtName.setText(LiveData.newInstance().getUser().getNames());
        binding.txtLastName.setText(LiveData.newInstance().getUser().getLastName());
        binding.txtEmail.setText(LiveData.newInstance().getUser().getEmail());
        binding.btnGoHome.setOnClickListener(view -> startActivity(new Intent(ConfirmDataActivity.this, HomeActivity.class)));
    }
}
