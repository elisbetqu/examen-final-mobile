#language: es
@login
Característica: Inicio de sesion con el app Saucelabs Demo
  Como usuario ya registrado
  Quiero ingresar mis credenciales
  Para poder usar la aplicacion

  Antecedentes:
    Dado que me encuentro en la aplicacion SauceLabsDemo

  @login_sauce_exitoso
  Esquema del escenario: Caso 01 - Inicio de sesión exitoso con credenciales correctas
    Cuando ingreso al Menu "Log In"
    Y me muestra la pantalla de "Login"
    E ingreso mi usuario "<sUserName>"
    E ingreso mi password "<sUserPassword>"
    Y presiono Login
    Entonces deberia mostrarme la pantalla de catalogo de productos "Products"
    Ejemplos:
      | sUserName       | sUserPassword |
      | bob@example.com | 10203040      |

  @login_sauce_fallido
  Escenario: Caso 02 - Inicio de sesion fallido con usuario y contraseña vacio
  Cuando ingreso al Menu "Log in"
  Y me muestra la pantalla de "Login"
  Pero no ingreso username ni password
  Y presiono Login
  Entonces me muestra el mensaje "Username is required"

  @validar_carrito_compras
  Esquema del escenario: Validar carrito de compras
  Y valido que carguen correctamente los productos en la galeria
  Cuando agrego <UNIDADES> del siguiente producto "<PRODUCTO>"
  Entonces valido el carrito de compra actualice correctamente
  Ejemplos:
  | PRODUCTO                  | UNIDADES |
  | Sauce Labs Backpack       | 1        |
  | Sauce Labs Bolt T-Shirt   | 1        |
  | Sauce Labs Bike Light     | 2        |











