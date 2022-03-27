package com.example.shoppingcrypto.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shoppingcrypto.databinding.ActivityLoginBinding;
import com.example.shoppingcrypto.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener, TextWatcher {
    private ActivityLoginBinding binding;
    private LoginPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        startUI();
    }

    private void startUI() {
        presenter = new LoginPresenter(this);
        binding.btnlogin.setOnClickListener(this);
        binding.btnRegister.setOnClickListener(this);
        binding.username.addTextChangedListener(this);
        binding.password.addTextChangedListener(this);
    }

    @Override
    public void onClick(View view) {
        if (binding.btnlogin == view) {
            presenter.showMesssage();
        } else if (binding.btnRegister == view) {
            startActivity(new Intent(this, RegisterActivity.class));
        }
    }

    @Override
    public void enableButton(boolean isEnable) {
        binding.btnlogin.setEnabled(isEnable);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        //
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        presenter.validateInputs(binding.username.getText().toString().trim(), binding.password.getText().toString().trim());
    }

    @Override
    public void afterTextChanged(Editable editable) {
        //
    }
}