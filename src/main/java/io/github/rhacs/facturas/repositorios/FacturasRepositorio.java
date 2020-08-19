package io.github.rhacs.facturas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.rhacs.facturas.modelos.Factura;

@Repository
public interface FacturasRepositorio extends JpaRepository<Factura, Long> {

}
