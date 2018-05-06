package modelo;

import java.io.Serializable;

public class Producto implements Serializable{

    String nombre,marca;
    String misNombres[];
    String talla,precio;
    Producto misZapatos [];

    public Producto() {
    }

    public Producto(String nombre, String marca, String talla, String precio) {
        this.nombre = nombre;
        this.marca = marca;
        this.talla = talla;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTalla() { return talla; }

    public void setTalla(String talla) { this.talla = talla; }

    public String getPrecio() { return precio; }

    public void setPrecio(String precio) { this.precio = precio; }

    @Override
    public String toString() {
        return this.nombre + " Marca: "+this.marca+" Precio: "+this.precio ;
    }

    public Producto [] cargarZapatos(){
        misZapatos = new Producto[] {
                new Producto("Predator","Adidas", "8","40"),
                new Producto("Mercurial","Nike", "8","90"),
                new Producto("Nyjah","DC", "7","98"),
                new Producto("Navy","Etnies", "10","100"),
                new Producto("SC400","UA", "11","150"),
                new Producto("Marana","Etnies", "9","45"),
                new Producto("Predator Futbol","Adidas","8","200"),
                new Producto("Puma Skate","Puma", "7","80"),
        };
        return misZapatos;
    }

    /*public String [] nombresDeZapatos(){
        misNombres = new String[cargarZapatos().length];
        for (int i=0;i<misNombres.length;i++){
            misNombres[i]=cargarZapatos()[i].getNombre();
        }
        return misNombres;
    }*/
}