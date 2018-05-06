package Control;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import modelo.Producto;

public class controlArchivoObjeto {
    private File file = Environment.getExternalStorageDirectory();
    private String ruta = file.getAbsolutePath() + File.separator;

    public void escribirArchivo(Producto p, String nombre) {

        try {
            FileOutputStream fos = new FileOutputStream(ruta + nombre);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(p);
            fos.close();
        } catch (FileNotFoundException e) {
            Log.e("error", e.toString());
        } catch (IOException e) {
            Log.e("error", e.toString());
        }
    }

    public Producto leerArchivo(String nombre) {
        Producto p = null;
        try {
            FileInputStream fis = new FileInputStream(ruta + nombre);
            ObjectInputStream in = new ObjectInputStream(fis);
            p = (Producto) in.readObject();
            fis.close();
        } catch (FileNotFoundException e) {
            Log.e("Error Archivo", e.toString());
        } catch (IOException e) {
            Log.e("Error IO", e.toString());
        } catch (ClassNotFoundException e) {
            Log.e("Error Persona", e.toString());
        }
        return p;
    }

    public ArrayList<Producto> leerArchivoArrayList(String nombre) {
        ArrayList<Producto> objectsList = new ArrayList<Producto>();
        try {
            Producto p = null;
            FileInputStream fis = new FileInputStream(ruta + nombre);
            ObjectInputStream in = new ObjectInputStream(fis);
            p = (Producto) in.readObject();
            objectsList.add(p);
            while (p != null) {
                p = (Producto) in.readObject();
                objectsList.add(p);
            }
            fis.close();
            return objectsList;
        } catch (FileNotFoundException e) {
            Log.e("Error Archivo", e.toString());
        } catch (IOException e) {
            Log.e("Error IO", e.toString());
        } catch (ClassNotFoundException e) {
            Log.e("Error Persona", e.toString());
        }
        return objectsList;
    }
}