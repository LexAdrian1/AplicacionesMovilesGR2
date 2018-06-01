package com.example.usuario.myapplicationtaller;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import Control.controlArchivoUser;
import modelo.Usuario;

public class RegistroActivity extends AppCompatActivity {
    TextView name;
    TextView mail;
    TextView pass;
    TextView repeatPass;
    Button registro;

    controlArchivoUser miregistroUsuario = new controlArchivoUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        name = (TextView) findViewById(R.id.editTextName);
        mail = (TextView) findViewById(R.id.editTextMail);
        pass = (TextView) findViewById(R.id.editTextPass);
        repeatPass = (TextView) findViewById(R.id.editTextRepeatPass);
        registro = (Button) findViewById(R.id.buttonRegistro);
    }

    public void registroUser(View view){
        if(pass.getText().toString().equals(repeatPass.getText().toString())){

            miregistroUsuario.creacionArchivo(new Usuario(name.getText().toString(),mail.getText().toString(),pass.getText().toString()),
                    "ListaUsuarios.txt");
            Toast.makeText(getApplicationContext(),"Usuario Registrado",Toast.LENGTH_SHORT).show();
            Intent intents = new Intent(getApplicationContext(), MainActivity.class);
            intents.putExtra("id",miregistroUsuario);
            startActivity(intents);
        }
        else{
            Toast.makeText(this,"Contraseña NO Coinciden",Toast.LENGTH_SHORT).show();

        }
    }
}
