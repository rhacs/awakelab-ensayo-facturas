----------------------------------------------------------------------------------------------------
-- Tabla: categoria
----------------------------------------------------------------------------------------------------

CREATE TABLE categoria (
    categoriaid NUMBER NOT NULL,
    nombre VARCHAR(50) NOT NULL,

    CONSTRAINT categoria_pk PRIMARY KEY (categoriaid)
);

----------------------------------------------------------------------------------------------------
-- Tabla: producto
----------------------------------------------------------------------------------------------------

CREATE TABLE producto (
    productoid NUMBER NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    valor NUMBER NOT NULL,
    categoriaid NUMBER NOT NULL,

    CONSTRAINT producto_pk PRIMARY KEY (productoid),
    CONSTRAINT producto_fk FOREIGN KEY (categoriaid) REFERENCES categoria (categoriaid)
);

----------------------------------------------------------------------------------------------------
-- Tabla: factura
----------------------------------------------------------------------------------------------------

CREATE TABLE factura (
    facturaid NUMBER NOT NULL,
    cliente VARCHAR(50) NOT NULL,
    fecha VARCHAR(10) NOT NULL,

    CONSTRAINT factura_pk PRIMARY KEY (facturaid)
);

----------------------------------------------------------------------------------------------------
-- Tabla: detallefactura
----------------------------------------------------------------------------------------------------

CREATE TABLE detallefactura (
    cantidad NUMBER NOT NULL,
    facturaid NUMBER NOT NULL,
    productoid NUMBER NOT NULL,

    CONSTRAINT detallefactura_pk PRIMARY KEY (cantidad, facturaid)
);
