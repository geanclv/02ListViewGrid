package com.example.a02listviewgrid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lstViewMain;
    private List<String> lstNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        lstNombre = initNamesList();

        //Adaptador que llenará el ListView
        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lstNombre);*/
        //Enlazamos el ListView con el Adaptador
        /*lstViewMain.setAdapter(adapter);*/

        //Click en el ListView
        lstViewMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nombre = lstNombre.get(position);
                Toast.makeText(MainActivity.this, "Clic en: " + nombre,
                        Toast.LENGTH_LONG).show();
            }
        });

        //P2LV - Enlazamos con nuestro adaptador personalizado
        //Inicializando el adaptador personalizado
        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, lstNombre);
        //Asignando el adaptador personalizado al ListView padre
        lstViewMain.setAdapter(myAdapter);
    }

    private List<String> initNamesList() {
        return new ArrayList<String>(){{
            add("Geancarlo");
            add("Alejandro");
            add("Juan");
            add("Jose");add("Geancarlo");
            add("Alejandro");
            add("Juan");
            add("Jose");add("Geancarlo");
            add("Alejandro");
            add("Juan");
            add("Jose");add("Geancarlo");
            add("Alejandro");
            add("Juan");
            add("Jose");
        }};
    }

    private void initComponents() {
        lstViewMain = findViewById(R.id.lstViewMain);
    }
}