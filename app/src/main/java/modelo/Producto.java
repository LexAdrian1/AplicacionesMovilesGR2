package modelo;

import java.io.Serializable;

public class Producto implements Serializable{

    String nombre,marca;
    String misNombres[];
    Integer talla,precio;
    Producto misZapatos [];

    public Producto() {
    }

    public Producto(String nombre, String marca, Integer talla, Integer precio) {
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


    public Integer getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return this.nombre + " Marca: "+this.marca+" Precio: "+this.precio ;
    }

    public Producto [] cargarZapatos(){
        misZapatos = new Producto[] {
                new Producto("Predator","Nike", 8,120),
                new Producto("skate","adidas", 5,95),
                new Producto("Nyjah","DC", 7,98),
                new Producto("Navy","etnies", 6,93),
                new Producto("Run","adidas", 11,80),
                new Producto("Marana","etnies", 10,100),
                new Producto("Predator","Nike", 8,120),
                new Producto("skate","adidas", 5,95),
                new Producto("Nyjah","DC", 7,98),
                new Producto("Navy","etnies", 6,93),
                new Producto("Run","adidas", 11,80),
                new Producto("Marana","etnies", 10,100),
                new Producto("Predator","Nike", 8,120),
                new Producto("skate","adidas", 5,95),
                new Producto("Nyjah","DC", 7,98),
                new Producto("Navy","etnies", 6,93),
                new Producto("Run","adidas", 11,80),
                new Producto("Marana","etnies", 10,100),
                new Producto("Predator","Nike", 8,120),
                new Producto("skate","adidas", 5,95),
                new Producto("Nyjah","DC", 7,98),
                new Producto("Navy","etnies", 6,93),
                new Producto("Run","adidas", 11,80),
                new Producto("Converse","converser", 5,70),
        };
        return misZapatos;
    }

    public String [] nombresDeZapatos(){
        misNombres = new String[cargarZapatos().length];
        for (int i=0;i<misNombres.length;i++){
            misNombres[i]=cargarZapatos()[i].getNombre();
        }
        return misNombres;
    }
}