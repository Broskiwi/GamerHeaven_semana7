package com.duoc.gamerheaven.controller;

import com.duoc.gamerheaven.model.Videojuego;
import com.duoc.gamerheaven.service.VideojuegoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/videojuegos")
public class VideojuegoController {

    private final VideojuegoService videojuegoService;

    public VideojuegoController(VideojuegoService videojuegoService) {
        this.videojuegoService = videojuegoService;
    }

    @GetMapping
    public ResponseEntity<List<Videojuego>> findAll() {
        return ResponseEntity.ok(videojuegoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Videojuego> findById(@PathVariable String id) {
        int parsedId = Integer.parseInt(id);
        return videojuegoService.findById(parsedId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<Videojuego> findByTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(videojuegoService.findByTitulo(titulo));
    }

    @GetMapping("/plataforma/{plataforma}")
    public ResponseEntity<List<Videojuego>> findByPlataforma(@PathVariable String plataforma) {
        return videojuegoService.findAllByPlataforma(plataforma)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Videojuego> save(@RequestBody Videojuego videojuego) {
        Videojuego created = videojuegoService.create(videojuego);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Videojuego> update(@PathVariable String id, @RequestBody Videojuego videojuego) {
        int parsedId = Integer.parseInt(id);
        Optional<Videojuego> updated = videojuegoService.update(parsedId, videojuego);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        int parsedId = Integer.parseInt(id);
        videojuegoService.delete(parsedId);
    }
}
