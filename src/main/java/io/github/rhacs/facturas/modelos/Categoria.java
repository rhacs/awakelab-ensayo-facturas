package io.github.rhacs.facturas.modelos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.github.rhacs.facturas.Constantes;

@Entity
@Table(name = Constantes.TABLA_CATEGORIAS)
public class Categoria {

    // Atributos
    // -----------------------------------------------------------------------------------------

    @Id
    @Column(name = "categoriaid", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @JsonIgnore
    @Transient
    private Set<Producto> productos;

    // Constructores
    // -----------------------------------------------------------------------------------------

    /**
     * Crea una nueva instancia vacía del objeto {@link Categoria}
     */
    public Categoria() {
        productos = new HashSet<>();
    }

    /**
     * Crea una nueva instancia del objeto {@link Categoria}
     * 
     * @param id        identificador numérico
     * @param nombre    nombre
     * @param productos listado de {@link Producto}s
     */
    public Categoria(Long id, String nombre, Set<Producto> productos) {
        this.id = id;
        this.nombre = nombre;
        this.productos = productos;
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
     * @return el listado de {@link Producto}s
     */
    public Set<Producto> getProductos() {
        return productos;
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
     * @param productos el listado de {@link Producto}s a establecer
     */
    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    // Herencias (Object)
    // -----------------------------------------------------------------------------------------

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

        Categoria other = (Categoria) obj;

        return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
    }

    @Override
    public String toString() {
        return String.format("Categoria [id=%s, nombre=%s, productos=%s]", id, nombre, productos);
    }

}
