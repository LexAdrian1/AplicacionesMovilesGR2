package com.example.usuario.myapplicationtaller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.view.View;

import modelo.Producto;

public class invitadoActivity extends AppCompatActivity {

    ListView miListaInvitado;
    ArrayAdapter<String> adapteri;
    String [] nombreDeZapatos;

    ArrayAdapter<Producto> adapter;
    Producto [] misZapatos;

    PopupMenu popUpMenuInvitado;
    PopupMenu popUpMenuUser;

    public void cargarNombres(){
        nombreDeZapatos = new Producto().nombresDeZapatos();
    }
    public void cargarZapatos(){
        misZapatos = new Producto().cargarZapatos();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitado);

        miListaInvitado = (ListView) findViewById(R.id.listaInvitado);
        //invitado = getIntent().getExtras().getString("idUser");
        //passInvitado = getIntent().getExtras().getString("idPass")

        if((getIntent().getExtras().getString("verificarUsuario")).equals("User")){
            cargarZapatos();
            adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,misZapatos);
            miListaInvitado.setAdapter(adapter);
        }else{
            cargarNombres();
            adapteri = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,nombreDeZapatos);
            miListaInvitado.setAdapter(adapteri);
        }

        miListaInvitado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int selecion, long l) {
                if((getIntent().getExtras().getString("verificarUsuario")).equals("User")){
                    selectMenuUser(view,selecion);
                }else{
                    selectMenuInvitado(view,selecion);
                }
            }
        });
    }

    public void selectMenuUser(View view,final int selecion)
    {
        popUpMenuUser= new PopupMenu(this, view);
        popUpMenuUser.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.ver:
                        Intent intent = new Intent(getApplicationContext(), detalleActivity.class);
                        intent.putExtra("id", misZapatos[selecion]);
                        startActivity(intent);
                        return true;
                    case R.id.comprar:
                        Toast.makeText(getApplicationContext(),"Producto Agregado",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.eliminar:
                        Toast.makeText(getApplicationContext(),"Producto Eliminado",Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popUpMenuUser.inflate(R.menu.user_menu);
        popUpMenuUser.show();
    }

    public void selectMenuInvitado(View view,final int selecion)
    {
        popUpMenuInvitado= new PopupMenu(this, view);
        popUpMenuInvitado.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.ver:
                        Intent intent = new Intent(getApplicationContext(), detalleActivity.class);
                        intent.putExtra("id", misZapatos[selecion]);
                        startActivity(intent);
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
}

