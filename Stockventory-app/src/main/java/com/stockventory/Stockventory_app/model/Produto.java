package com.stockventory.Stockventory_app.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tipo;
    private String nome ;
    private String marca;
    private int quantidade;
    private double custounit;
    private double porclucro;
    private double valorvenda;

    public Produto() {

    }

    public Produto(Long id, String nome, String tipo, String marca, Double custounit, Double porclucro, Integer quantidade, Double valorvenda) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.marca = marca;
        this.custounit = custounit;
        this.porclucro = porclucro;
        this.quantidade = quantidade;
        this.valorvenda = valorvenda;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getCustounit() {
        return custounit;
    }

    public void setCustounit(double custounit) {
        this.custounit = custounit;
    }

    public double getPorclucro() {
        return porclucro;
    }

    public void setPorclucro(double porclucro) {
        this.porclucro = porclucro;
    }

    public double getValorvenda() {
        return valorvenda;
    }

    public void setValorvenda(double valorvenda) {
        this.valorvenda = valorvenda;
    }

    public void CalcVenda (double valorvenda, double porclucro, double custounit) {
        this.valorvenda = porclucro*custounit;
    }
}
