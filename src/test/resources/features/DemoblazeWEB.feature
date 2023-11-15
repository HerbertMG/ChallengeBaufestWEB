# language: es

Característica: Realizar el llenado del carrito de compras
  Como nuevo cliente
  Quiero ingresar a la web https://www.demoblaze.com/index.html
  y crear un nuevo usuario
  Para añadir mis productos al carrito de compras

  @Escenario1
  Esquema del escenario: Agregar articulos al carrito de compras como cliente nuevo
    Dado que un nuevo cliente ingresa a la web
    Y se registre con sus nuevas credenciales usuario herbert202356789029 y constraseña 123456789
    Cuando se haga login con sus credenciales usuario herbert202356789029 y constraseña 123456789
    Y se seleccione un producto al carrito
      | <categoria> | <producto> |
    Entonces en el carrito se muestra los productos agregados
      | <producto> |

    Ejemplos:
      | categoria | producto    |
      | Laptops   | MacBook Pro |
