package Control;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import modelo.Usuario;

public class controlArchivoUser implements Serializable {
    private File archivo = Environment.getExternalStorageDirectory();
    private String ruta = archivo.getAbsolutePath()+File.separator;
    private File file;


    public void creacionArchivo(Usuario user, String nombreArchivos ){
        file = new File(ruta+nombreArchivos);
        if (file.exists()){
            HashMap<String,Object> miListaUsuarios = new HashMap<String, Object>();
            miListaUsuarios = leerArchivo(nombreArchivos);
            miListaUsuarios.put(user.getMail(),user);
            escribirArchivo(miListaUsuarios,nombreArchivos);
        }else{
            try {
                if (file.createNewFile()){
                    escribirArchivo(misUsuarios(user),nombreArchivos);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public HashMap<String,Object> misUsuarios(Usuario usuario){
        HashMap<String,Object> miListaUsuarios=new HashMap();
        miListaUsuarios.put(usuario.getMail(),usuario);
        return miListaUsuarios;
    }

    public void escribirArchivo(HashMap<String,Object> misUsers, String nombreArchivos){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(ruta+nombreArchivos);
            out = new ObjectOutputStream(fos);
            out.writeObject(misUsers);
            fos.close();
        } catch (FileNotFoundException e) {
            Log.e("Error archivo",e.toString());
        } catch (IOException e) {
            Log.e("Error IO",e.toString());
        }
    }

    public HashMap<String,Object> leerArchivo(String nombreArchivo) {
        HashMap<String,Object> misUsuarios = new HashMap<String, Object>();
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(ruta + nombreArchivo);
            in = new ObjectInputStream(fis);
            misUsuarios = (HashMap<String, Object>) in.readObject();
        } catch (FileNotFoundException e) {
            Log.e("Error Archivo", e.toString());
        } catch (IOException e) {
            Log.e("Error IO", e.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return misUsuarios;
    }
}
