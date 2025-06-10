/*
package com.stockventory.Stockventory_app.controller;


import com.stockventory.Stockventory_app.model.Produto;
import com.stockventory.Stockventory_app.repository.ProdutoRepositorio;
import com.stockventory.Stockventory_app.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
 /*
    private final ProdutoRepositorio produtoRepositorio;

    public ProdutoController(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }
  @GetMapping
    public List<Produto> listarProdutos() {
        return produtoRepositorio.findAll();
    }


import com.stockventory.Stockventory_app.model.Produto;
import com.stockventory.Stockventory_app.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@GetMapping
    public List<Produto> listar() {

      //  return produtoService.listarTodos();
    return produtoService.listarTodos();
    }
    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @PostMapping
    public String teste(@RequestBody Produto teste) {
        return ("nome: " + teste.getNome());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable String nome) {
        Produto produto = (Produto) produtoService.Consultar(nome);
        return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
*/

package com.stockventory.Stockventory_app.controller;


import com.stockventory.Stockventory_app.model.Produto;
import com.stockventory.Stockventory_app.repository.ProdutoRepositorio;
import com.stockventory.Stockventory_app.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

            import java.util.List;

    @RestController
    @RequestMapping("/api/produtos")
    public class ProdutoController {

        @Autowired
        private ProdutoService service;

        @GetMapping()
        public List<Produto> findAll() {
            return service.listarTodos();
        }

        @GetMapping("/nome/{nome}")
        public List<Produto> findByName(@PathVariable("nome") String name) {
            return service.Consultar("%" + name + "%");
        }

        @PostMapping
        public String post(@RequestBody Produto produto) {
            Produto a = service.save(produto);

            return "Cadastro realizado com sucesso: " + a.getNome();
        }

        @PutMapping("/{id}")
        public String put(@PathVariable("id") long id, @RequestBody Produto produto) {
            Produto a = service.update(id, produto);

            return "Atualização realizada com sucesso: " + a.getNome();
        }

        @DeleteMapping("/{id}")
        public String delete(@PathVariable("id") long id) {
            service.delete(id);

            return "Cadastro removido com sucesso!";
        }
    }
