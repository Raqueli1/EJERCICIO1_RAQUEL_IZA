Ejercicio 1 SerenityBDD - Automatización de interfaz web portal de compras

Herramientas Utilizadas

Java 18

Serenity BDD v4.1.14

JUnit Platform v1.10.2

Cucumber JUnit Platform v7.14.0

JUnit Jupiter v5.10.2

JUnit Vintage v5.10.2

Logback Classic v1.2.10

AssertJ Core v3.25.3

Patron screenplay
Use este patron porque es una forma estructurada y eficiente para escribir pruebas automatizadas, cuando se trabaja con serenity y cucumber.

La estructura que maneja es :
src
	java
		-tasks → Contiene clases que representan acciones del usuario
		-questions → Clases encargadas de realizar validaciones
		-userinterface → Mapeo de elementos de la interfaz web
	test
		-runners → Clases encargadas de ejecutar los escenarios
		-stepdefinitions → Implementación de los pasos definidos en los archivos
	resources
		-features → Archivos .feature que describen los escenarios en lenguaje Gherkin.


Descripción Ejercicio 1

Este proyecto automatiza pruebas funcionales sobre una aplicación web de compras electrónicas, utilizando el enfoque Screenplay con Serenity BDD. Los flujos automatizados validan la experiencia del usuario en los siguientes escenarios clave:

-Inicio de sesión exitoso con credenciales válidas.

-Proceso completo de compra, desde la selección de productos hasta la confirmación final.

-Verificación de mensajes en pantalla y comportamientos de la interfaz, asegurando que las funcionalidades respondan correctamente a las acciones del usuario.


Requisitos Previos

-Java 18 instalado

-Gradle 7+ instalado 

-Navegador Chrome

-ChromeDriver 


Ejecución del proyecto y generación de reportes

1.Ubícate en la raíz del proyecto desde la terminal o consola de comandos.

2.Ejecuta el siguiente comando para compilar, ejecutar las pruebas y generar los reportes:

gradle.bat clean test aggregate

3.Una vez finalizada la ejecución, Serenity generará los reportes en la carpeta:

target/site/serenity/

4.Abre el archivo index.html en tu navegador para visualizar el reporte completo de ejecución:

target/site/serenity/index.html


