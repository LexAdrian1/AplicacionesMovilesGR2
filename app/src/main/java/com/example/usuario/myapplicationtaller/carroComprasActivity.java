package com.example.usuario.myapplicationtaller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Control.controlArchivoObjeto;
import modelo.Producto;

public class carroComprasActivity extends AppCompatActivity {
    ListView listacompras;
    controlArchivoObjeto controladorArchivo = new controlArchivoObjeto();
    ArrayAdapter<Producto> adapterCarro;
    List<Producto> your_array_list = new ArrayList<Producto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrocompras);
        listacompras = (ListView)findViewById(R.id.ListaCompras);
        your_array_list=controladorArchivo.leerArchivoArrayList("Productos.txt");
        adapterCarro = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, your_array_list );
        listacompras.setAdapter(adapterCarro);
    }
}
