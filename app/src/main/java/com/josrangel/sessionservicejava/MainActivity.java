package com.josrangel.sessionservicejava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.josrangel.sessionservicejava.utils.DialogUtils;

/**
 * Source:
 * https://stackoverflow.com/questions/37833738/difference-between-textinputlayout-and-textinputedittext
 */

public class MainActivity extends AppCompatActivity {

    TextInputEditText etUserName;
    TextInputEditText etPassword;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        etUserName = findViewById(R.id.et_user_name);
        etPassword = findViewById(R.id.et_password);
        btnSignIn = findViewById(R.id.btn_sign_in);

        btnSignIn.setOnClickListener(v -> userValidation());
    }

    private void userValidation() {
        boolean userIsCorrect = etUserName.getText().toString().equals("usuario");
        boolean passwordIsCorrect = etPassword.getText().toString().equals("1111");

        if (userIsCorrect && passwordIsCorrect) {
            initSessionActivity();
        } else {
            showError();
        }
    }

    private void initSessionActivity() {
        Intent i = new Intent(MainActivity.this, SessionActivity.class);
        i.putExtra("user", etUserName.getText().toString());
        startActivity(i);
    }

    private void showError() {
        DialogUtils.makeDialog(this);
    }
}