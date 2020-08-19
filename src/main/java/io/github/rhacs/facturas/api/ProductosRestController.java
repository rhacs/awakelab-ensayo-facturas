package io.github.rhacs.facturas.api;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.rhacs.facturas.modelos.Categoria;
import io.github.rhacs.facturas.modelos.Producto;
import io.github.rhacs.facturas.repositorios.CategoriasRepositorio;
import io.github.rhacs.facturas.repositorios.ProductosRepositorio;

@RestController
@RequestMapping(path = "/api/productos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductosRestController {

    // Constantes
    // -----------------------------------------------------------------------------------------

    private static final Logger logger = LogManager.getLogger(ProductosRestController.class);

    // Atributos
    // -----------------------------------------------------------------------------------------

    @Autowired
    private ProductosRepositorio productosRepositorio;

    @Autowired
    private CategoriasRepositorio categoriasRepositorio;

    // Solicitudes GET
    // -----------------------------------------------------------------------------------------

    /**
     * Muestra todos los {@link Producto}s del repositorio
     * 
     * @return un objeto {@link List} con el resultado
     */
    @GetMapping
    public List<Producto> getAllProductos() {
        return productosRepositorio.findAll();
    }

    /**
     * Busca los {@link Producto}s relacionados a la {@link Categoria} proporcionada
     * 
     * @param id identificador numérico de la {@link Categoria}
     * @return un objeto {@link List} con el resultado
     */
    @GetMapping(path = "/categoria/{id:^[0-9]+$}")
    public List<Producto> getProductosByCategoria(@PathVariable Long id) {
        // Buscar información de la categoría
        Categoria categoria = categoriasRepositorio.findById(id).orElseThrow();

        // Depuración
        logger.info("[API] Buscando los productos para la categoría: {}", categoria);

        // Buscar los productos relacionados a la categoría
        List<Producto> productos = productosRepositorio.findByCategoria(categoria);

        // Depuración
        logger.info("[API] Productos encontrados: {}", productos);

        // Buscar todos los productos relacionados a la categoría y devolver el objeto
        return productos;
    }

}
