package com.stockventory.Stockventory_app.service;

import com.stockventory.Stockventory_app.model.Produto;
import com.stockventory.Stockventory_app.repository.ProdutoRepositorio;
import jakarta.annotation.PostConstruct;


public class DataLoader {
    private final ProdutoRepositorio produtoRepositorio;

    public DataLoader(ProdutoRepositorio produtoRepositorio) {

        this.produtoRepositorio = produtoRepositorio;
    }

    @PostConstruct
    public void init() {
        if(produtoRepositorio.count() == 0) {

                produtoRepositorio.save(new Produto(1L,"calça leggin","calça","Tommy", 25,90.0,4,500.0));

            System.out.println("Dados iniciais carregados com sucesso!");
        }
    }
}
