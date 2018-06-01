package com.example.usuario.myapplicationtaller;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;

import Control.controlArchivoUser;
import modelo.Usuario;


public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText pass;
    Button user;
    Button invitado;
    Button registrar;
    String verificarUser;
    SignInButton signInGoogle;
    private controlArchivoUser registroUsers = new controlArchivoUser();
    //Crear un cliente del API de google
    //Codigo de Respuesta es 9001
    private GoogleApiClient googleApiClient;
    private final int CODERC=9001;
    private File archivo = Environment.getExternalStorageDirectory();
    private String ruta = archivo.getAbsolutePath()+File.separator;
    private File file;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)  findViewById(R.id.editTextName);
        pass = (EditText)  findViewById(R.id.editTextPass);
        user = (Button)  findViewById(R.id.buttonUser);
        invitado = (Button)  findViewById(R.id.buttonInvitado);
        registrar = (Button)findViewById(R.id.buttonRegistro);
        signInGoogle = (SignInButton) findViewById(R.id.buttonSignInGoogle);
        signInGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logeoGmail();
            }
        });
    }

    public void logeoGmail(){
        if (googleApiClient != null) {
            //Desconectado
            googleApiClient.disconnect();
        }
        //Solicitar correo para Iniciar Sesion
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().build();

        //Igualar al Cliente con el Logeo
        googleApiClient = new GoogleApiClient.Builder(this).addApi(Auth.GOOGLE_SIGN_IN_API,googleSignInOptions).build();
        //Abrir ventana de google
        Intent signIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(signIntent,CODERC);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODERC) {
            GoogleSignInResult result = Auth //resultado de la cesion
                    .GoogleSignInApi
                    .getSignInResultFromIntent(data);
            if (result.isSuccess()){

                Intent intent = new Intent(getApplicationContext(),listaActivity.class);
                GoogleSignInAccount acc=result.getSignInAccount();
                String token = acc.getIdToken();
                /*Log.e("correo",acc.getEmail());
                Log.e("nombre",acc.getDisplayName());
                Log.e("id",acc.getId());
                Log.e("foto",acc.getPhotoUrl().toString());*/
                intent.putExtra("idUser",acc.getDisplayName());
                intent.putExtra("idPass",acc.getEmail());
                startActivity(intent);
                if (token != null){
                    Toast.makeText(this,token,Toast.LENGTH_LONG).show();
                }
                Toast.makeText(this,"Correcto",Toast.LENGTH_LONG).show();
            }
        }
    }


    public void openRegistro(View view){
        Intent intents = new Intent(getApplicationContext(), RegistroActivity.class);
        startActivity(intents);
    }


    public void openUser(View view) {
        existeArchivo("ListaUsuarios.txt");
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

    public void existeArchivo(String nombreArchivo){
        if(registroUsers.leerArchivo(nombreArchivo).containsKey(name.getText().toString())) {
            Usuario usuarioRegistrado = (Usuario) registroUsers.leerArchivo(nombreArchivo).get(name.getText().toString());
            if (pass.getText().toString().equals(usuarioRegistrado.getPass())) {
                file = new File(ruta + nombreArchivo);
                if (file.exists()) {
                    Intent intents = new Intent(getApplicationContext(), listaActivity.class);
                    intents.putExtra("verificarUsuario", verificarUser="User".toString());
                    startActivity(intents);
                }
            } else {
                Toast.makeText(getApplicationContext(), "Password incorrecto", Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(getApplicationContext(), "No existe", Toast.LENGTH_LONG).show();
        }
    }
}