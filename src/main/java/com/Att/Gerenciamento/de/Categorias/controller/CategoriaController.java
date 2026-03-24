package com.Att.Gerenciamento.de.Categorias.controller;

import com.Att.Gerenciamento.de.Categorias.entity.Categoria;
import com.Att.Gerenciamento.de.Categorias.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    // POST /categorias
    @PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria) {
        Categoria nova = service.salvar(categoria);
        return ResponseEntity.ok(nova);
    }

    // GET /categorias
    @GetMapping
    public ResponseEntity<List<Categoria>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }

    // GET /categorias/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        Optional<Categoria> categoria = service.buscarPorId(id);

        return categoria
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /categorias/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}