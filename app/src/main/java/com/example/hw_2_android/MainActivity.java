package com.example.hw_2_android;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText etEmail;
    EditText etPassword;
    Button button;
    TextView orSign;
    TextView FYpassword;

    TextView sign;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etEmail = findViewById(R.id.ET_email);
        etPassword = findViewById(R.id.ET_password);
        button = findViewById(R.id.button);
        orSign = findViewById(R.id.orSign);
        FYpassword = findViewById(R.id.FYpassword);
        sign = findViewById(R.id.TV_sign);

        etEmail.addTextChangedListener(textWatcher);
        etPassword.addTextChangedListener(textWatcher);


        hasWrittenChecker();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if (email.equals("admin") && password.equals("admin")) {
                    Snackbar.make(v, " Вы успешно зарегистрировались",
                            Snackbar.LENGTH_LONG).show();
                    etEmail.setVisibility(View.GONE);
                    etPassword.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);
                    FYpassword.setVisibility(View.GONE);
                    orSign.setVisibility(View.GONE);
                    sign.setVisibility(View.GONE);

                } else {
                    Snackbar.make(v, "Неверный логин или пароль",
                            Snackbar.LENGTH_LONG).show();
                }

            }
        });
    }

    @SuppressLint("ResourceAsColor")

    private void hasWrittenChecker() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (!email.isEmpty() && !password.isEmpty()) {
            button.setBackgroundColor(getResources().getColor(R.color.orange));
            button.setEnabled(true);
        } else {
            button.setBackgroundColor(getResources().getColor(R.color.gray));
            button.setEnabled(false);
        }
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            hasWrittenChecker();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }


    };
}