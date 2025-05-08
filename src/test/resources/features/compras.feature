Feature: Proceso de compra con autenticación en el sitio web https://www.saucedemo.com/

  Scenario Outline: Autenticación del usuario y proceso completo de compra
    Given El usuario ingresa al sitio web de la tienda saucedemo
    When ingresa credenciales válidas en los campos de usuario y contraseña
      | <usuario> | <contrasena> |
    Then el usuario accede a la página principal y continúa con la compra de dos productos
    Examples:
      | usuario       | contrasena   |
      | standard_user | secret_sauce |