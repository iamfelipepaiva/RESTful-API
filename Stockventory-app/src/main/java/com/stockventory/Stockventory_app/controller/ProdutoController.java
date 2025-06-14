package com.stockventory.Stockventory_app.controller;


import com.stockventory.Stockventory_app.model.Produto;
import com.stockventory.Stockventory_app.repository.ProdutoRepositorio;
import com.stockventory.Stockventory_app.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

//http://localhost:8080/swagger-ui/index.html#/ - DOCUMENTAÇÃO SWAGGER


    @Tag(name = "Stockventory controller", description = "Operações relacionadas à solicitações HTTP CRUD")
    @RestController
    @RequestMapping("/api/stockventory") //produtos
    public class ProdutoController {

        @Autowired
        private ProdutoService service;

        @Operation(summary = "Exibir todos")
        @GetMapping()
        public List<Produto> findAll() {
            return service.listarTodos();
        }

        @Operation(summary = "Pesquisar pelo nome")
        @GetMapping("/nome/{nome}")
        public List<Produto> findByName(@PathVariable("nome") String name) {
            return service.Consultar("%" + name + "%");
        }

        @Operation(summary = "Adicionar produto")
        @PostMapping
        public String post(@RequestBody Produto produto) {
            Produto a = service.save(produto);

            return "Cadastro realizado com sucesso: " + a.getNome();
        }

        @Operation(summary = "Atualizar por id")
        @PutMapping("/{id}")
        public String put(@PathVariable("id") long id, @RequestBody Produto produto) {
            Produto a = service.update(id, produto);

            return "Atualização realizada com sucesso: " + a.getNome();
        }

        @Operation(summary = "Deletar por id")
        @DeleteMapping("/{id}")
        public String delete(@PathVariable("id") long id) {
            service.delete(id);

            return "Cadastro removido com sucesso!";
        }
    }
