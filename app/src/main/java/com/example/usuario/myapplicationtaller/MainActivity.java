package com.example.usuario.myapplicationtaller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText pass;
    Button user;
    Button invitado;
    String verificarUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)  findViewById(R.id.editTextName);
        pass = (EditText)  findViewById(R.id.editTextPass);
        user = (Button)  findViewById(R.id.buttonUser);
        invitado = (Button)  findViewById(R.id.buttonInvitado);

    }

    public void openUser(View view) {
        if (name.getText().toString().equals("user") && (pass.getText().toString().equals("123"))) {
            Intent intents = new Intent(getApplicationContext(), listaActivity.class);
            intents.putExtra("verificarUsuario", verificarUser="User".toString());
            /*intents.putExtra("idUser", user.getText().toString());
            intents.putExtra("idPass", pass.getText().toString());*/
            startActivity(intents);
        } else {
            Toast.makeText(getApplicationContext(), "Usuario o Contrasenia Incorrecta", Toast.LENGTH_SHORT).show();
        }
    }

    public void openInvitado(View view) {
        if ((name.getText().toString().isEmpty()) && (pass.getText().toString().isEmpty())) {
            Intent intents = new Intent(getApplicationContext(), listaActivity.class);
            /*intents.putExtra("idUser", user.getText().toString());
            intents.putExtra("idPass", pass.getText().toString());*/
            intents.putExtra("verificarUsuario", verificarUser="Invitado".toString());
            startActivity(intents);
        }else {
            Toast.makeText(getApplicationContext(), "Validar", Toast.LENGTH_SHORT).show();
        }
    }

    public void openScanner(View view) {
        Intent intents = new Intent(getApplicationContext(), scannerQRActivity.class);
        startActivity(intents);
    }
}