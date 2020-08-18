package io.github.rhacs.facturas.modelos;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import io.github.rhacs.facturas.Constantes;

@Entity
@Table(name = Constantes.TABLA_DETALLEFACTURA)
public class DetalleFactura {

    // Atributos
    // -----------------------------------------------------------------------------------------

    @EmbeddedId
    private DetalleFacturaCK id;

    @Column(columnDefinition = "NUMBER", nullable = false)
    private Long cantidad;

    @ManyToOne
    @MapsId(value = "facturaid")
    @JoinColumn(name = "facturaid")
    private Factura factura;

    @ManyToOne
    @MapsId(value = "productoid")
    @JoinColumn(name = "productoid")
    private Producto producto;

    // Constructores
    // -----------------------------------------------------------------------------------------

    /**
     * Crea una nueva instancia vacía del objeto {@link DetalleFactura}
     */
    public DetalleFactura() {

    }

    /**
     * Crea una nueva instancia del objeto {@link DetalleFactura}
     * 
     * @param id       identificador numérico compuesto
     * @param cantidad cantidad
     * @param factura  {@link Factura} relacionada
     * @param producto {@link Producto} relacionado
     */
    public DetalleFactura(DetalleFacturaCK id, Long cantidad, Factura factura, Producto producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.factura = factura;
        this.producto = producto;
    }

    // Getters
    // -----------------------------------------------------------------------------------------

    /**
     * @return el identificador numérico compuesto
     */
    public DetalleFacturaCK getId() {
        return id;
    }

    /**
     * @return la cantidad
     */
    public Long getCantidad() {
        return cantidad;
    }

    /**
     * @return la {@link Factura} relacionada
     */
    public Factura getFactura() {
        return factura;
    }

    /**
     * @return el {@link Producto} relacionado
     */
    public Producto getProducto() {
        return producto;
    }

    // Setters
    // -----------------------------------------------------------------------------------------

    /**
     * @param id el identificador numérico compuesto a establecer
     */
    public void setId(DetalleFacturaCK id) {
        this.id = id;
    }

    /**
     * @param cantidad la cantidad a establecer
     */
    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @param factura la {@link Factura} a establecer
     */
    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    /**
     * @param producto el {@link Producto} a establecer
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    // Herencias (Object)
    // -----------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        DetalleFactura other = (DetalleFactura) obj;

        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return String.format("DetalleFactura [id=%s, cantidad=%s]", id, cantidad);
    }

}
