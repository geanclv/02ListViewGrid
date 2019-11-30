package com.example.a02listviewgrid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private GridView gridView;
    private List<String> lstNombre;

    private MyAdapter myAdapter;

    private int contador = 0;

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

        myAdapter = new MyAdapter(this, R.layout.grid_item, lstNombre);
        gridView.setAdapter(myAdapter);
    }

    /*Para trabajar con Menús en la barra de opciones:
    * 1. En la carpeta res: Crear un Android resource directory del tipo: menu
    * 2. En el directorio creado: Agregar un Menu resource file
    * 3. Modificar a gusto el Menu resource file
    * 4. Sobreescribir los métodos onCreateOptionsMenu y onOptionsItemSelected
    * */

    //Creamos el menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    //Cuando hacemos clic en uno de nuestros menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                this.lstNombre.add("Agregado N°: " + (++contador));
                //Notificando al adaptador que la data ha cambiado
                this.myAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private List<String> initNamesList() {
        return new ArrayList<String>(){{
            add("Geancarlo");
            add("Alejandro");
            add("Juan");
        }};
    }

    private void initComponents() {
        gridView = findViewById(R.id.gridView);
    }
}
