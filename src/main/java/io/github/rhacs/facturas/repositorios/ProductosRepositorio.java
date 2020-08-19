package io.github.rhacs.facturas.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.rhacs.facturas.modelos.Categoria;
import io.github.rhacs.facturas.modelos.Producto;

@Repository
public interface ProductosRepositorio extends JpaRepository<Producto, Long> {

    /**
     * Busca un listado de registros en el repositorio que estén relacionados con la
     * {@link Categoria} proporcionada
     * 
     * @param categoria {@link Categoria} a buscar
     * @return un objeto {@link List} con el resultado
     */
    public List<Producto> findByCategoria(Categoria categoria);

}
