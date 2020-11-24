package com.daniel.logincustomview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    LoginView loginView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginView = findViewById(R.id.login);

        loginView.setHeaderText("Login");
        loginView.setInputTextHint("User");
        loginView.setPassTextHint("Password");
        String inputValue = loginView.getInputTextValue();
        String passValue = loginView.getPassTextValue();
        loginView.setButtonText("Click Me");

        loginView.setButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               loginView.setButtonText("Clicked !");
            }
        });
    }
}