package com.miguelcr.a01_simplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    String[] students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.list_view);

        students = new String[]{"Mateo","X",
                "Adán",
                "Cristian",
                "Emilio",
                "Jacobo",
                "Cristofer",
                "Camilo",
                "Pablo",
                "Bartolomeo",
                "Simón",
                "Martin",
                "Carlos",
                "Marcelo",
                "Marcelo II",
                "Conrado"
        };

        ArrayAdapter<String> adapterStudent = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                students
        );

        lista.setAdapter(adapterStudent);
        lista.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String studentNameClicked = students[position];
        Toast.makeText(MainActivity.this, "Name: "+studentNameClicked,
                Toast.LENGTH_SHORT).show();

        view.animate().rotationX(360).setDuration(2000).start();

    }
}
