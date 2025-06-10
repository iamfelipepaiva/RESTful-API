package com.stockventory.Stockventory_app.repository;

import com.stockventory.Stockventory_app.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
    List<Produto> findByNomeLike(String Nome);


}

