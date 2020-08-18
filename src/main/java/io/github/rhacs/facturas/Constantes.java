package io.github.rhacs.facturas;

public class Constantes {

    // Tablas
    // -----------------------------------------------------------------------------------------

    /**
     * Nombre de la tabla que contiene la información de las {@link Factura}s
     */
    public static final String TABLA_FACTURAS = "factura";

    /**
     * Nombre de la tabla que contiene la información de las {@link Categoria}s
     */
    public static final String TABLA_CATEGORIAS = "categoria";

    /**
     * Nombre de la tabla que contiene la información de los {@link Producto}s
     */
    public static final String TABLA_PRODUCTOS = "producto";

    /**
     * Nombre de la tabla que contiene la información de los {@link DetalleFactura}
     */
    public static final String TABLA_DETALLEFACTURA = "detallefactura";

    // Constructores
    // -----------------------------------------------------------------------------------------

    private Constantes() {
        // Constructor privado para esconder el constructor público implícito
    }

}
