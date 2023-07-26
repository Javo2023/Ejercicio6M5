package com.example.ejercicio6m5;

public class Item {
    private String titulo;
    private String imagen;

    public Item(String titulo, String imagen){
        this.titulo = titulo;
        this.imagen = imagen;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getImagen(){
        return imagen;
    }
}
