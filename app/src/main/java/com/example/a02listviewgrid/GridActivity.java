package com.example.a02listviewgrid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private GridView gridView;
    private List<String> lstNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        initComponents();

        lstNombre = initNamesList();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridActivity.this, "Clic", Toast.LENGTH_LONG).show();
            }
        });

        MyAdapter myAdapter = new MyAdapter(this, R.layout.grid_item, lstNombre);
        gridView.setAdapter(myAdapter);
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
        gridView = findViewById(R.id.gridView);
    }
}
