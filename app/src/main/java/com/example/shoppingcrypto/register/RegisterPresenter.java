package com.example.shoppingcrypto.register;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.shoppingcrypto.MainActivity;
import com.example.shoppingcrypto.confirm_data.ConfirmDataActivity;
import com.example.shoppingcrypto.model.LiveData;
import com.example.shoppingcrypto.model.User;

public class RegisterPresenter {
    private final Activity activity;
    private final RegisterView view;

    public RegisterPresenter(Activity activity) {
        this.activity = activity;
        this.view = (RegisterView) activity;
    }

    public void showMesssage() {
        Toast.makeText(this.activity, "Realizó el registro correctamente!", Toast.LENGTH_LONG).show();
        this.activity.startActivity(new Intent(this.activity, ConfirmDataActivity.class));
    }

    public void validateInputs(String names, String lastName, String email, String emailConfirm, String password, String passwordConfirm) {
        boolean isValid = names.length() > 3
                && lastName.length() > 3
                && email.length() > 5
                && email.equalsIgnoreCase(emailConfirm)
                && password.length() > 4
                && password.equalsIgnoreCase(passwordConfirm);
        this.view.enableButton(isValid);
        if (isValid) {
            User user = new User();
            user.setNames(names);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword(password);
            LiveData.newInstance().setUser(user);
        }
    }
}
