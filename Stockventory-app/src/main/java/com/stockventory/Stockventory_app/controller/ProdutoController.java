package com.stockventory.Stockventory_app.controller;


import com.stockventory.Stockventory_app.model.Produto;
import com.stockventory.Stockventory_app.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Optional;

    @Tag(name = "Stockventory controller", description = "Operações relacionadas à solicitações HTTP CRUD")
    @RestController
    @RequestMapping("/api/stockventory")
    public class ProdutoController {

        @Autowired
        private ProdutoService service;

        @Operation(summary = "Adicionar produto")
        @PostMapping
        public String post(@Valid @RequestBody Produto produto){
            Produto temp = service.save(produto);
            return "Cadastro realizado com sucesso: " + temp.getNome();
        }

        @Operation(summary = "Pesquisar pelo nome")
        @GetMapping("/nome/{nome}")
        public List<Produto> findByName(@PathVariable("nome") String name) {
            return service.Consultar("%" + name + "%");
        }

        @Operation(summary = "Pesquisar pelo id")
        @GetMapping("/{id}")
        public Optional<Produto> findById(@PathVariable("id") Long id) {
            return service.getProductById(id);
        }

        @Operation(summary = "Atualizar por id")
        @PutMapping("/{id}")
        public String put(@PathVariable("id") long id, @RequestBody Produto produto) {
            Produto temp = service.update(id, produto);
            return "Atualização realizada com sucesso: " + temp.getNome();
        }

        @Operation(summary = "Deletar através id")
        @DeleteMapping("/{id}")
        public String delete(@PathVariable("id") long id) {
            service.delete(id);
            return "Cadastro removido com sucesso!";
        }

        @Operation(summary = "Exibir todos")
        @GetMapping()
        public List<Produto> findAll() {
            return service.listarTodos();
        }

    }
