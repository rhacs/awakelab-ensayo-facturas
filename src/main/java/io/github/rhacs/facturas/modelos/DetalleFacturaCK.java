package io.github.rhacs.facturas.modelos;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetalleFacturaCK implements Serializable {

    // Constantes
    // -----------------------------------------------------------------------------------------

    /**
     * Número de serie de la clase
     */
    private static final long serialVersionUID = 552978689702958609L;

    // Atributos
    // -----------------------------------------------------------------------------------------

    @Column(name = "facturaid")
    private Long facturaId;

    @Column(name = "productoid")
    private Long productoId;

    // Constructores
    // -----------------------------------------------------------------------------------------

    /**
     * Crea una nueva instancia vacía del objeto {@link DetalleFacturaCK}
     */
    public DetalleFacturaCK() {

    }

    /**
     * Crea una nueva instancia del objeto {@link DetalleFacturaCK}
     * 
     * @param facturaId  identificador numérico de la {@link Factura}
     * @param productoId identificador numérico del {@link Producto}
     */
    public DetalleFacturaCK(Long facturaId, Long productoId) {
        this.facturaId = facturaId;
        this.productoId = productoId;
    }

    // Getters
    // -----------------------------------------------------------------------------------------

    /**
     * @return el identificador numérico de la {@link Factura}
     */
    public Long getFacturaId() {
        return facturaId;
    }

    /**
     * @return el identificador numérico del {@link Producto}
     */
    public Long getProductoId() {
        return productoId;
    }

    // Setters
    // -----------------------------------------------------------------------------------------

    /**
     * @param facturaId el identificador numérico de la {@link Factura} a establecer
     */
    public void setFacturaId(Long facturaId) {
        this.facturaId = facturaId;
    }

    /**
     * @param productoId el identificador numérico del {@link Producto} a establecer
     */
    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    // Herencias (Object)
    // -----------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        return Objects.hash(facturaId, productoId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        DetalleFacturaCK other = (DetalleFacturaCK) obj;

        return Objects.equals(facturaId, other.facturaId) && Objects.equals(productoId, other.productoId);
    }

    @Override
    public String toString() {
        return String.format("DetalleFacturaCK [facturaId=%s, productoId=%s]", facturaId, productoId);
    }

}
