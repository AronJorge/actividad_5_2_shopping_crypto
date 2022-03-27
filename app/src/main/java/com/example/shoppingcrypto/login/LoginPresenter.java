package com.example.shoppingcrypto.login;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.shoppingcrypto.MainActivity;
import com.example.shoppingcrypto.home.HomeActivity;
import com.example.shoppingcrypto.model.LiveData;
import com.example.shoppingcrypto.model.User;

public class LoginPresenter {
    private final Activity activity;
    private final LoginView view;

    public LoginPresenter(Activity activity) {
        this.activity = activity;
        this.view = (LoginView) activity;
    }

    public void showMesssage() {
        Toast.makeText(this.activity, "Iniciaste sesión correctamente!", Toast.LENGTH_LONG).show();
        this.activity.startActivity(new Intent(this.activity, HomeActivity.class));
    }

    public void validateInputs(String user, String password) {
        this.view.enableButton((user.length() > 4 && password.length() > 4));
        if ((user.length() > 4 && password.length() > 4)) {
            User userDto =new User();
            userDto.setNames(user);
            LiveData.newInstance().setUser(userDto);
        }
    }
}
