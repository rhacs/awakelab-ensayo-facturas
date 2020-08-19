package io.github.rhacs.facturas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.rhacs.facturas.modelos.Categoria;

@Repository
public interface CategoriasRepositorio extends JpaRepository<Categoria, Long> {

}
