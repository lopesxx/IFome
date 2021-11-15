package com.marcelo.ifome.Domain;

import java.io.Serializable;

public class ComidaDomain implements Serializable {
    private String titulo;
    private String foto;
    private String descricao;
    private Double preco;
    private int numberInCard;

    public ComidaDomain(String titulo, String foto, String descricao, Double preco) {
        this.titulo = titulo;
        this.foto = foto;
        this.descricao = descricao;
        this.preco = preco;
    }

    public ComidaDomain(String titulo, String foto, String descricao, Double preco, int numberInCard) {
        this.titulo = titulo;
        this.foto = foto;
        this.descricao = descricao;
        this.preco = preco;
        this.numberInCard = numberInCard;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void getPreco(Double preco) {
        this.preco = preco;
    }

    public int getNumberInCard() {
        return numberInCard;
    }

    public void setNumberInCard(int numberInCard) {
        this.numberInCard = numberInCard;
    }
}
