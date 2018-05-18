package modelo;

import java.io.Serializable;

public class Producto implements Serializable{

    String nombre,marca;
    String talla,precio,codigo;
    Producto misZapatos [];

    public Producto() {
    }

    public Producto(String nombre, String marca, String talla, String precio,String codigo) {
        this.nombre = nombre;
        this.marca = marca;
        this.talla = talla;
        this.precio = precio;
        this.codigo = codigo;
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

    public String getCodigo() { return codigo; }

    @Override
    public String toString() {
        return this.nombre + " Marca: "+this.marca+" Precio: "+this.precio ;
    }

    public Producto [] cargarZapatos(){
        misZapatos = new Producto[] {
                new Producto("Predator","Adidas", "8","40","001"),
                new Producto("Mercurial","Nike", "8","90","002"),
                new Producto("Nyjah","DC", "7","98","003"),
                new Producto("Navy","Etnies", "10","100","005"),
                new Producto("SC400","UA", "11","150","006"),
                new Producto("Marana","Etnies", "9","45","007"),
                new Producto("Predator Futbol","Adidas","8","200","008"),
                new Producto("Puma Skate","Puma", "7","80","010"),
        };
        return misZapatos;
    }
}