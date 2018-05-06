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
    public controlArchivoObjeto controladorArchivoObjeto = new controlArchivoObjeto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        nombre = (EditText) findViewById(R.id.editText);
        marca = (EditText) findViewById(R.id.editText2);
        talla = (EditText) findViewById(R.id.editText3);
        precio = (EditText) findViewById(R.id.editText4);
        agregar = (Button) findViewById(R.id.buttonAgregar);
        Producto detallesZapatos = (Producto) getIntent().getExtras().getSerializable("id");
        nombre.setText(detallesZapatos.getNombre());
        marca.setText(detallesZapatos.getMarca());
        talla.setText(String.valueOf(detallesZapatos.getTalla()));
        precio.setText(String.valueOf(detallesZapatos.getPrecio()));
        //Toast.makeText(getApplicationContext(),getIntent().getExtras().getString ("indice").toString(), Toast.LENGTH_LONG).show();

    }

    /*public void agregarProductoArchivo(View view){
        controladorArchivoObjeto.escribirArchivo(new Producto(nombre.getText().toString(),marca.getText().toString(),talla.getText().toString(),precio.getText().toString()),"Productos.txt");
        Toast.makeText(getApplicationContext(),"Producto Agregado", Toast.LENGTH_LONG).show();
        LimpiarCampos();
    }

    public  void leerArchivo(View view){
        //Producto p = controladorArchivoObjeto.leerArchivo("Productos.txt");
        //controladorArchivoObjeto.leerArchivo("Productos.txt");
        //Toast.makeText(getApplicationContext(),p.toString(), Toast.LENGTH_LONG).show();
        ArrayList<Producto>  arrayListp =  controladorArchivoObjeto.leerArchivoArrayList("Productos.txt");
        for (Producto member : arrayListp){
            Log.i("Member name: ", member.toString());
        }
    }
    public void LimpiarCampos(){
        nombre.setText("");
        marca.setText("");
        talla.setText("");
        precio.setText("");
    }*/
}
