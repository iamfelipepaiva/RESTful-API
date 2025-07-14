package com.stockventory.Stockventory_app.service;

import com.stockventory.Stockventory_app.model.Produto;
import com.stockventory.Stockventory_app.repository.ProdutoRepositorio;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//Test class
@Component
@Profile("dev")
public class DataLoader {
    private final ProdutoRepositorio produtoRepositorio;

    public DataLoader(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    @PostConstruct
    public void init() {
        if(produtoRepositorio.count() == 0) {
            Produto produto = new Produto();
            produto.setNome("Produto de teste");
            produto.setTipo("Exemplo");
            produto.setMarca("Marca X");
            produto.setQuantidade(10);
            produto.setCustounit(50.0);
            produto.setPorclucro(20.0);
            produto.calcularVenda();
            produtoRepositorio.save(produto);

            System.out.println("Dados iniciais carregados com sucesso!");
        }
    }
}
