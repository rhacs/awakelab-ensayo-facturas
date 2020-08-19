package io.github.rhacs.facturas.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.rhacs.facturas.modelos.Factura;
import io.github.rhacs.facturas.repositorios.FacturasRepositorio;

@Controller
@RequestMapping(path = "/")
public class HomeController {

    // Atributos
    // -----------------------------------------------------------------------------------------

    @Autowired
    private FacturasRepositorio facturasRepositorio;

    // Solicitudes GET
    // -----------------------------------------------------------------------------------------

    @GetMapping
    public String verFormulario(@RequestParam Optional<Long> id, Model modelo) {
        // Verificar si el id está presente
        if (id.isPresent()) {
            // Buscar información de la factura
            Optional<Factura> factura = facturasRepositorio.findById(id.get());

            // Verificar si existe
            if (factura.isPresent()) {
                // Insertar factura en el modelo
                modelo.addAttribute("factura", factura.get());
            }
        }

        // Mostrar vista
        return "facturas";
    }

}
