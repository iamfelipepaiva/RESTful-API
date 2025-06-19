package com.stockventory.Stockventory_app.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
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
    /*
    public void CalcVenda (double valorvenda, double porclucro, double custounit) {
        this.valorvenda = porclucro*custounit;
    }
    */
    public void CalcVenda() {
        if (this.custounit > 0 && this.porclucro > 0) {
            this.valorvenda = this.custounit * (1 + (this.porclucro / 100));
        }
    }
}
