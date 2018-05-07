package com.example.usuario.myapplicationtaller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import Control.controlArchivoObjeto;
import modelo.Producto;

public class detalleActivity extends AppCompatActivity {
    EditText nombre;
    EditText marca;
    EditText talla;
    EditText precio;
    Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


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
