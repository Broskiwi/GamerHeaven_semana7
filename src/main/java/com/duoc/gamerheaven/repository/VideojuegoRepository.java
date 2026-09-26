package com.duoc.gamerheaven.repository;

import com.duoc.gamerheaven.model.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer> {
    Videojuego findByTitulo(String titulo);
    List<Videojuego> findAllByPlataformaIgnoreCase(String plataforma);
}
