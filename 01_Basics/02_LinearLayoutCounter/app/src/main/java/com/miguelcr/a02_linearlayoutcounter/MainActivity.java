package com.miguelcr.a02_linearlayoutcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int counter = 0;
    TextView textCounter;
    Button btnMinus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textCounter = (TextView) findViewById(R.id.text_counter);
        btnMinus = (Button) findViewById(R.id.button_minus);
    }
    // Decrease the counter and update the textView
    public void subCounter(View view) {
        if(counter==0) {
            Toast.makeText(this,"Limit 0",Toast.LENGTH_LONG).show();
        } else {
            counter--;
            if(counter==0) {
                btnMinus.setVisibility(View.INVISIBLE);
            }
            textCounter.setText(String.valueOf(counter));
        }
    }
    // Increase the counter and update the textView
    public void addCounter(View view) {
        counter++;
        textCounter.setText(String.valueOf(counter));
        btnMinus.setVisibility(View.VISIBLE);
    }
}
