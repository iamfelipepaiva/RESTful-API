
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

    // Listar todos os produtos
    public List<Produto> listarTodos() {
        return produtoRepositorio.findAll();
    }

    // Buscar produtos por nome
    public List<Produto> Consultar(String nome) {
        return produtoRepositorio.findByNomeLike(nome);
    }

    //Buscar por id
    public Optional<Produto> getProductById(Long id) {
        return produtoRepositorio.findById(id);
    }

    // Salvar um novo produto
    public Produto save(Produto produto) {
        return produtoRepositorio.save(produto);
    }

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
            bd.setValorvenda(produto.getValorvenda());
            return produtoRepositorio.save(bd);
        } else {
            throw new RuntimeException("Produto não encontrado para atualização");
        }
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

