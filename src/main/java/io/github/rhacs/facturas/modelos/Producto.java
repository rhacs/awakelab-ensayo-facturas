package io.github.rhacs.facturas.modelos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.github.rhacs.facturas.Constantes;

@Entity
@Table(name = Constantes.TABLA_PRODUCTOS)
public class Producto {

    // Atributos
    // -----------------------------------------------------------------------------------------

    @Id
    @Column(name = "productoid", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Long valor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoriaid", nullable = false)
    private Categoria categoria;

    @OneToMany(mappedBy = "producto", fetch = FetchType.EAGER)
    @JsonIgnore
    @Transient
    private Set<DetalleFactura> detalleFacturas;

    // Constructores
    // -----------------------------------------------------------------------------------------

    /**
     * Crea una nueva instancia vacía del objeto {@link Producto}
     */
    public Producto() {
        detalleFacturas = new HashSet<>();
    }

    /**
     * Crea una nueva instancia del objeto {@link DetalleFactura}
     * 
     * @param id              identificador numérico
     * @param nombre          nombre
     * @param valor           valor
     * @param categoria       {@link Categoria}
     * @param detalleFacturas listado de {@link DetalleFactura}
     */
    public Producto(Long id, String nombre, Long valor, Categoria categoria, Set<DetalleFactura> detalleFacturas) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.categoria = categoria;
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
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return el valor
     */
    public Long getValor() {
        return valor;
    }

    /**
     * @return la {@link Categoria}
     */
    public Categoria getCategoria() {
        return categoria;
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
     * @param nombre el nombre a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param valor el valor a establecer
     */
    public void setValor(Long valor) {
        this.valor = valor;
    }

    /**
     * @param categoria la {@link Categoria} a establecer
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * @param detalleFacturas el listado de {@link DetalleFactura} a establecer
     */
    public void setDetalleFacturas(Set<DetalleFactura> detalleFacturas) {
        this.detalleFacturas = detalleFacturas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Producto other = (Producto) obj;

        return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
    }

    @Override
    public String toString() {
        return String.format("Producto [id=%s, nombre=%s, valor=%s]", id, nombre, valor);
    }

}
