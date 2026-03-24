package com.Att.Gerenciamento.de.Categorias.repository;

import com.Att.Gerenciamento.de.Categorias.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}