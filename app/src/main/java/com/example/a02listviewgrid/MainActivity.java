package com.example.a02listviewgrid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lstViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        //Datos que se mostrarán en el ListView
        List<String> lstNombre = initNamesList();

        //Adaptador que llenará el ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lstNombre);
        //Enlazamos el ListView con el Adaptador
        lstViewMain.setAdapter(adapter);

    }

    private List<String> initNamesList() {
        return new ArrayList<String>(){{
            add("Geancarlo");
            add("Alejandro");
            add("Juan");
            add("Jose");
            add("Geancarlo");
            add("Alejandro");
            add("Juan");
            add("Jose");
            add("Geancarlo");
            add("Alejandro");
            add("Juan");
            add("Jose");
        }};
    }

    private void initComponents() {
        lstViewMain = findViewById(R.id.lstViewMain);
    }
}
