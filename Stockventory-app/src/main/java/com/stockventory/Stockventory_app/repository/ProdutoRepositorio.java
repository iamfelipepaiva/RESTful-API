package com.stockventory.Stockventory_app.repository;

import com.stockventory.Stockventory_app.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.lang.ScopedValue;
import java.util.List;


public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
    List<Produto> findByNomeLike(String Nome);

    void deleteByid(long id);

    String Nome(String nome);

/*
public interface ProdutoRepositorio extends CrudRepository<Produto, Integer> {

    List<Produto> findByNome(String nome);

    ScopedValue<Object> findById(Long id);

    void deleteById(Long id);


 */
}

