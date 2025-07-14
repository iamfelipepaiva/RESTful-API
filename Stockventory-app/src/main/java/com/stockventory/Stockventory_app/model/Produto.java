package com.stockventory.Stockventory_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
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

    @NotBlank(message = "O tipo é obrigatório")
    private String tipo;

    @NotBlank(message = "O nome é obrigatório")
    private String nome ;

    @NotBlank(message = "A marca é obrigatória")
    private String marca;

    @Min(value = 1, message = "A quantidade deve ser maior que zero")
    private int quantidade;

    @Positive(message = "O custo unitário deve ser positivo")
    private double custounit;

    @Positive(message = "A porcentagem de lucro deve ser positiva")
    private double porclucro;

    @Positive(message = "O valor da venda deve ser positivo")
    private double valorvenda;

    public Produto() {}

    public void calcularVenda() {
        if (this.custounit > 0 && this.porclucro > 0) {
            this.valorvenda = this.custounit * (1 + (this.porclucro / 100));
        }
    }

    public void setCustounit(double custounit) {
        this.custounit = custounit;
        calcularVenda();
    }

    public void setPorclucro(double porclucro) {
        this.porclucro = porclucro;
        calcularVenda();
    }
}
