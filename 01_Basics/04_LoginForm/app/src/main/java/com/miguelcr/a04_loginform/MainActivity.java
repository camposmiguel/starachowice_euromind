package com.miguelcr.a04_loginform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.edit_text_email);
        pass = (EditText) findViewById(R.id.edit_text_password);
    }

    public void checkLogin(View view) {
        if(user.getText().toString().equals("admin@admin.com") &&
                pass.getText().toString().equals("1234")) {
            Toast.makeText(this,"Login ok",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"Login wrong!!!!",Toast.LENGTH_LONG).show();
        }
    }
}
