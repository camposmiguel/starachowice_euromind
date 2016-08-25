package com.miguelcr.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HelloWorldActivity extends AppCompatActivity {
    EditText code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);

        code = (EditText) findViewById(R.id.edit_text_code);

    }

    public void showCode(View view) {
        String userCode = code.getText().toString();

        Toast.makeText(HelloWorldActivity.this,
                "The secret code is "+userCode,
                Toast.LENGTH_LONG).show();
    }
}
