package com.example.shoppingcrypto.register;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shoppingcrypto.databinding.ActivityRegisterBinding;
import com.example.shoppingcrypto.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity implements RegisterView, View.OnClickListener, TextWatcher {
    private ActivityRegisterBinding binding;
    private RegisterPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityRegisterBinding.inflate(LayoutInflater.from(this));
        setContentView(this.binding.getRoot());
        startUI();
    }

    private void startUI() {
        presenter = new RegisterPresenter(this);
        binding.login.setOnClickListener(this);
        binding.btnRegister.setOnClickListener(this);
        binding.names.addTextChangedListener(this);
        binding.lastName.addTextChangedListener(this);
        binding.email.addTextChangedListener(this);
        binding.confirmEmail.addTextChangedListener(this);
        binding.password.addTextChangedListener(this);
        binding.passwordConfirm.addTextChangedListener(this);
    }

    @Override
    public void onClick(View view) {
        if (binding.btnRegister == view) {
            presenter.showMesssage();
        } else if (binding.login == view) {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    @Override
    public void enableButton(boolean isEnable) {
        binding.btnRegister.setEnabled(isEnable);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        //
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        presenter.validateInputs(binding.names.getText().toString().trim(),
                binding.lastName.getText().toString().trim(),
                binding.email.getText().toString().trim(),
                binding.confirmEmail.getText().toString().trim(),
                binding.password.getText().toString().trim(),
                binding.passwordConfirm.getText().toString().trim()
        );
    }

    @Override
    public void afterTextChanged(Editable editable) {
        //
    }
}
