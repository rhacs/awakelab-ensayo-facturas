# awakelab-ensayo-facturas

## Problema
Un negocio de ventas mayoristas posee una base de datos que almacena cada una de las facturas que se emiten, la fecha en que esto se hace, y los productos que se asocian a cada una.

Se debe crear un portal web compuesto por dos secciones:

 * Búsqueda de factura por ID: se debe considerar una caja de texto y un botón; al presionar el botón se desplegará en la parte inferior de la página o en una página adicional el detalle de la factura (nombre de cliente y fecha), el listado de productos dentro de una tabla, el subtotal, el monto de impuesto y el total. Considere que el impuesto a aplicar asciende como de costumbre a un 19% del total de la compra.
 * Servicio de búsqueda de productos por categoría: se debe crear un servicio REST que entregue  en  formato  JSON  el  listado de productos  de  una  categoría  determinada.  El servicio debe recibir en la URL el id de la categoría a evaluar.

## Requerimientos
 * Debe crear un portal compuesto solo por una página vista, o bien una página inicial un campo de texto y un botón junto con una página en la que se despliegue el listado de productos solicitado.
 * El sistema debe ser construido utilizando el framework Spring MVC, conectándose a una base de datos Oracle 11g express.
 * Si se crea más de una vista, las debe asociar por medio de vínculos HTML.
 * Debe crear un servicio REST que retorne el listado de productos de una categoría en formato  JSON. Este  servicio  debe recibir un identificador de categoría en formato numérico, y se asume que ese valor será entregado al servicio.
 * Dado que el servicio REST no será utilizado directamente en el sitio, debe validar que realice las tareas esperadas usando un software adicional, tal como Postman.
 * En las tablas no existen campos autoincrementales.
 * La revisión del problema se realizará en base al modelo antes planteado; no se permite agregar, modificar o quitar campos del modelo.