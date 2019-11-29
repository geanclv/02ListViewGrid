package com.example.a02listviewgrid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

//Parte 2 de listView (P2LV): Creando el adaptador para soportar el layout: list_item
public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> lstNombres;

    public MyAdapter(Context context, int layout, List<String> lstNombres) {
        this.context = context;
        this.layout = layout;
        this.lstNombres = lstNombres;
    }

    @Override
    public int getCount() {
        return this.lstNombres.size();
    }

    @Override
    public Object getItem(int position) {
        return this.lstNombres.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*View Holder Pattern -> nos permite mejorar la performace debido a que almacena
        * en cache las referencias*/
        ViewHolder holder;

        if (convertView == null) {
            //Inflando la vista con el layout creado (list_item)
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout, null);

            holder = new ViewHolder();
            //Agregando la referencia del textView al Holder
            holder.txtViewMain = convertView.findViewById(R.id.textView);

            //llenando el holder
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //Copiando la vista recibida para trabajarla
        //View view = convertView;

        //Obtenemos el valor actual para mostrar
        String nombre = this.lstNombres.get(position);

        //Completando el textView del layout
        //TextView textView = view.findViewById(R.id.textView);
        //textView.setText(nombre);
        holder.txtViewMain.setText(nombre);

        //Devolvemos la Vista inflada y modificada con nuestros datos
        //return view;
        return convertView;
    }

    //Clase ViewHolder
    static class ViewHolder {
        //atributos como los tiene mi layout a renderizar y el método getView del adaptador
        private TextView txtViewMain;


    }
}
