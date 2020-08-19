<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <!-- Codificación de Caracteres -->
        <meta charset="utf-8">

        <!-- Configuración inicial de ancho y escala inicial -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
            integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
            crossorigin="anonymous">

        <!-- Título -->
        <title>Facturas</title>
    </head>
    <body>
        <div class="container py-4">
            <div class="row justify-content-center">
                <div class="col-lg-10 col-md-12">
                    <h1 class="text-center mb-4">Simulación 2</h1>

                    <div class="card mb-4">
                        <div class="card-body">
                            <form action="${pageContext.request.contextPath}" method="get">
                            <div class="row justify-content-center">
                                <div class="col-sm-3 col-xs-12 mb-3">
                                    <p class="card-text mt-2">Factura ID:</p>
                                </div>
                                <div class="col-sm-3 col-xs-12 mb-3">
                                    <input type="number" name="id" min="1" pattern="[0-9]+" class="form-control" autofocus required>
                                </div>
                                <div class="col-sm-3 col-xs-12">
                                    <button type="submit" class="btn btn-primary w-100">Obtener</button>
                                </div>
                            </div>
                            </form>
                        </div>
                    </div>

                    <core:if test="${not empty factura}">
                        <div class="card mb-3">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-sm-4 col-xs-12">
                                        <p class="card-text"><strong>Cliente:</strong></p>
                                    </div>
                                    <div class="col-sm-8 col-xs-12">
                                        <p class="card-text">${factura.getCliente()}</p>
                                    </div>
                                    <div class="col-sm-4 col-xs-12">
                                        <p class="card-text"><strong>Fecha:</strong></p>
                                    </div>
                                    <div class="col-sm-8 col-xs-12">
                                        <p class="card-text">${factura.getFecha()}</p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="table-responsive">
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col" class="text-nowrap">Producto</th>
                                        <th scope="col" class="text-nowrap text-right">Cantidad</th>
                                        <th scope="col" class="text-nowrap text-right">Precio</th>
                                        <th scope="col" class="text-nowrap text-right">SubTotal</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <core:forEach items="${factura.getDetalleFacturas()}" var="detalle">
                                        <tr>
                                            <td>${detalle.getProducto().getNombre()}</td>
                                            <td class="text-right">${detalle.getCantidad()}</td>
                                            <td class="text-right"><fmt:formatNumber currencyCode="CLP" type="currency" value="${detalle.getProducto().getValor()}" /></td>
                                            <td class="text-right"><fmt:formatNumber currencyCode="CLP" type="currency" value="${detalle.getCantidad() * detalle.getProducto().getValor()}" /></td>
                                        </tr>
                                    </core:forEach>
                                    <tr>
                                        <th scope="row" colspan="3" class="text-right">SubTotal</th>
                                        <td class="text-right"><fmt:formatNumber currencyCode="CLP" type="currency" value="${factura.getSubtotal()}" /></td>
                                    </tr>
                                    <tr>
                                        <th scope="row" colspan="3" class="text-right">Impuesto</th>
                                        <td class="text-right"><fmt:formatNumber currencyCode="CLP" type="currency" value="${factura.getImpuesto()}" /></td>
                                    </tr>
                                    <tr>
                                        <th scope="row" colspan="3" class="text-right">Total</th>
                                        <td class="text-right"><fmt:formatNumber currencyCode="CLP" type="currency" value="${factura.getTotal()}" /></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </core:if>
                </div>
            </div>
        </div>

        <!-- Dependencias JavaScript -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>
    </body>
</html>
