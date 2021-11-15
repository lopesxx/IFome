package com.marcelo.ifome.Domain;

import java.io.Serializable;

public class CategoriaDomain implements Serializable {
    private String titulo;
    private String foto;

    public CategoriaDomain(String titulo, String foto) {
        this.titulo = titulo;
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
