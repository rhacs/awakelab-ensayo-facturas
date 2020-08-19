package io.github.rhacs.facturas.modelos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.github.rhacs.facturas.Constantes;

@Entity
@Table(name = Constantes.TABLA_FACTURAS)
public class Factura {

    // Atributos
    // -----------------------------------------------------------------------------------------

    @Id
    @Column(name = "facturaid", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String cliente;

    @Column(nullable = false)
    private String fecha;

    @OneToMany(mappedBy = "factura")
    private Set<DetalleFactura> detalleFacturas;

    // Constructores
    // -----------------------------------------------------------------------------------------

    /**
     * Crea una nueva instancia vacía del objeto {@link Factura}
     */
    public Factura() {
        detalleFacturas = new HashSet<>();
    }

    /**
     * Crea una nueva instancia del objeto {@link Factura}
     * 
     * @param id              identificador numérico
     * @param cliente         nombre del cliente
     * @param fecha           fecha en que se emitió la {@link Factura}
     * @param detalleFacturas el listado de {@link DetalleFactura}
     */
    public Factura(Long id, String cliente, String fecha, Set<DetalleFactura> detalleFacturas) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.detalleFacturas = detalleFacturas;
    }

    // Getters
    // -----------------------------------------------------------------------------------------

    /**
     * @return el identificador numérico
     */
    public Long getId() {
        return id;
    }

    /**
     * @return el nombre del cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @return la fecha de emisión
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @return el listado de {@link DetalleFactura}
     */
    public Set<DetalleFactura> getDetalleFacturas() {
        return detalleFacturas;
    }

    // Setters
    // -----------------------------------------------------------------------------------------

    /**
     * @param id el identificador numérico a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param cliente el nombre del cliente a establecer
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @param fecha la fecha de emisión a establecer
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @param detalleFacturas el listado de {@link DetalleFactura} a establecer
     */
    public void setDetalleFacturas(Set<DetalleFactura> detalleFacturas) {
        this.detalleFacturas = detalleFacturas;
    }

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

        Factura other = (Factura) obj;

        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return String.format("Factura [id=%s, cliente=%s, fecha=%s, detalleFacturas=%s]", id, cliente, fecha,
                detalleFacturas);
    }

}
