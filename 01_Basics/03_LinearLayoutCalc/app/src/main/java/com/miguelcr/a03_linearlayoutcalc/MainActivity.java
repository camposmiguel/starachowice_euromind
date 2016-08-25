package com.miguelcr.a03_linearlayoutcalc;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView screen;
    int op1, op2;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (TextView) findViewById(R.id.text_view_screen);
        // Change the font type for screen TextView
        Typeface type = Typeface.createFromAsset(getAssets(),
                "triple_dot_digital.ttf");
        screen.setTypeface(type);
    }

    public void clickNumber(View view) {
        int idClicked = view.getId();
        String newText = "";
        if(idClicked==R.id.button_7) {
            newText = "7";
        } else if(idClicked==R.id.button_8) {
            newText = "8";
        } else if(idClicked==R.id.button_6) {
            newText = "6";
        }

        if(screen.getText().toString().equals("0")) {
            screen.setText(newText);
        } else {
            screen.setText(screen.getText() + newText);
        }
    }

    public void clickOperation(View view) {
        int idClicked = view.getId();

        if(idClicked==R.id.button_add) { // Add operation
            operator = "+";
        } else if(idClicked==R.id.button_sub) { // Subs operation
            operator = "-";
        } //...

        op1 = Integer.parseInt(screen.getText().toString());
        screen.setText("");
    }

    public void clickEqual(View view) {
        op2 = Integer.parseInt(screen.getText().toString());
        int result = 0;
        if(operator.equals("+")) {
            result = op1 + op2;
        } else if(operator.equals("-")) {
            result = op1 - op2;
        }
        screen.setText(String.valueOf(result));
    }
}
