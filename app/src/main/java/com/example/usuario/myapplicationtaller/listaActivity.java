package com.example.usuario.myapplicationtaller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

import Control.controlArchivoObjeto;
import modelo.Producto;

public class listaActivity extends AppCompatActivity {

    ListView miListaInvitado;
    ArrayAdapter<String> adapteri;
    String [] nombreDeZapatos;
    public controlArchivoObjeto controladorArchivoObjeto = new controlArchivoObjeto();
    public ArrayList<Producto> arrayListCarrito = new ArrayList<Producto>();
    ArrayAdapter<Producto> adapter;
    Producto [] misZapatos;

    PopupMenu popUpMenuInvitado;
    PopupMenu popUpMenuUser;

    public void cargarZapatos(){
        misZapatos = new Producto().cargarZapatos();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        miListaInvitado = (ListView) findViewById(R.id.listaInvitado);
        //invitado = getIntent().getExtras().getString("idUser");
        //passInvitado = getIntent().getExtras().getString("idPass")

        if((getIntent().getExtras().getString("verificarUsuario")).equals("User")){
            cargarZapatos();
            adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,misZapatos);
            miListaInvitado.setAdapter(adapter);
        }else{
            cargarZapatos();
            adapteri = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,cargarNombres());
            miListaInvitado.setAdapter(adapteri);
        }

        miListaInvitado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int selecion, long l) {
                if((getIntent().getExtras().getString("verificarUsuario")).equals("User")){
                    selectMenuUser(view,misZapatos[selecion]);
                }else{
                    selectMenuInvitado(view,misZapatos[selecion]);
                }
            }
        });
    }

    public String [] cargarNombres(){
        nombreDeZapatos = new String[misZapatos.length];
        for (int i=0;i<nombreDeZapatos.length;i++){
            nombreDeZapatos[i]=misZapatos[i].getNombre();
        }
        return nombreDeZapatos;
    }

    public void selectMenuUser(View view,final Producto objProducto)
    {
        popUpMenuUser= new PopupMenu(this, view);
        popUpMenuUser.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.ver:
                        envioObjeto(objProducto);
                        return true;
                    case R.id.comprar:
                        arrayListCarrito.add(new Producto(objProducto.getNombre().toString(),
                                objProducto.getMarca().toString(),
                                objProducto.getTalla().toString(),
                                objProducto.getPrecio().toString()));
                        Toast.makeText(getApplicationContext(),"Producto Agregado",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.eliminar:
                        controladorArchivoObjeto.escribirArchivoArrayList(arrayListCarrito,"Productos.txt");
                        Toast.makeText(getApplicationContext(),"Producto Eliminado",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), carroComprasActivity.class);
                        startActivity(intent);
                        return true;
                    default:
                        return false;
                }
            }
        });
        popUpMenuUser.inflate(R.menu.user_menu);
        popUpMenuUser.show();
    }

    public void selectMenuInvitado(View view, final Producto objProducto)
    {
        popUpMenuInvitado= new PopupMenu(this, view);
        popUpMenuInvitado.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.ver:
                        envioObjeto(objProducto);
                        return true;
                    case R.id.comprar:
                        Toast.makeText(getApplicationContext(),"Debes Iniciar Sesion",Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popUpMenuInvitado.inflate(R.menu.invitado_menu);
        popUpMenuInvitado.show();
    }

    public void envioObjeto(Producto objProducto){
        Intent intent = new Intent(getApplicationContext(), detalleActivity.class);
        intent.putExtra("id", objProducto);
        startActivity(intent);
    }


}

