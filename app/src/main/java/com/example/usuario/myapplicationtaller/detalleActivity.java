package com.example.usuario.myapplicationtaller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import modelo.Producto;

public class detalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText nombre;
        EditText marca;
        EditText talla;
        EditText precio;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        nombre = (EditText) findViewById(R.id.editText);
        marca = (EditText) findViewById(R.id.editText2);
        talla = (EditText) findViewById(R.id.editText3);
        precio = (EditText) findViewById(R.id.editText4);

        Producto detallesZapatos = (Producto) getIntent().getExtras().getSerializable("id");
        nombre.setText(detallesZapatos.getNombre());
        marca.setText(detallesZapatos.getMarca());
        talla.setText(String.valueOf(detallesZapatos.getTalla()));
        precio.setText(String.valueOf(detallesZapatos.getPrecio()));


    }
}
