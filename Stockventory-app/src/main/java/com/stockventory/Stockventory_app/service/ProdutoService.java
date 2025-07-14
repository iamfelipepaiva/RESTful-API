
package com.stockventory.Stockventory_app.service;

import com.stockventory.Stockventory_app.model.Produto;
import com.stockventory.Stockventory_app.repository.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    public Produto update(long id, Produto produto) {
        Optional<Produto> opc = produtoRepositorio.findById(id);
        if (opc.isPresent()) {
            Produto bd = opc.get();
            bd.setTipo(produto.getTipo());
            bd.setNome(produto.getNome());
            bd.setMarca(produto.getMarca());
            bd.setCustounit(produto.getCustounit());
            bd.setPorclucro(produto.getPorclucro());
            bd.setQuantidade(produto.getQuantidade());

            return produtoRepositorio.save(bd);
        } else {
            throw new RuntimeException("Produto não encontrado para atualização");
        }
    }

    public Produto save(Produto produto) {
        produto.calcularVenda();
        return produtoRepositorio.save(produto);
    }

    public Optional<Produto> getProductById(Long id) {
        return produtoRepositorio.findById(id);
    }

    public List<Produto> Consultar(String nome) {
        return produtoRepositorio.findByNomeLike(nome);
    }

    public List<Produto> listarTodos() {
        return produtoRepositorio.findAll();
    }

    public void delete(long id) {
        Optional<Produto> opc = produtoRepositorio.findById(id);
        if (opc.isPresent()) {
            produtoRepositorio.deleteById(id);
        } else {
            throw new RuntimeException("Produto não encontrado para deleção");
        }
    }
}

