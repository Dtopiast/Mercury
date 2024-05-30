# Mercury

Mercury Library Console App es una aplicación de línea de comandos que te permite interactuar con una biblioteca de libros utilizando una API RESTful llamada gutendex.

## Descripción

Esta aplicación te permite realizar las siguientes acciones:

- Ver la lista de libros disponibles en la biblioteca.
- Buscar un libro por su título.
- Ver los detalles de un libro específico.
- Consultar información sobre autores, géneros, y más.

## Requerimientos

- Java Development Kit (JDK) 21 o superior.
- Maven para construir y administrar dependencias.

## Configuración

Antes de ejecutar la aplicación, asegúrate de configurar la URL de la API RESTful de gutendex. en el archivo de configuración `application.properties`.

```properties
# Archivo: application.properties
```

## URL de la API RESTful de gutendex
```
url.api.url=https://gutendex.com/
```

## Uso

Para ejecutar la aplicación, sigue estos pasos:

  - Clona el repositorio de GitHub.
  - Configura la URL de la API RESTful en el archivo application.properties.
  - Compila la aplicación utilizando Maven:

```bash
mvn clean package
```
Ejecuta la aplicación:

```bash
    java -jar target/mercury-console-app.jar
```
## Contribución

Las contribuciones son bienvenidas. Si deseas contribuir a este proyecto, sigue estos pasos:

- Haz un fork del repositorio.
- Crea una nueva rama (git checkout -b feature/feature-name).
- Realiza tus cambios y haz commit (git commit -am 'Add new feature').
- Sube tus cambios a tu repositorio (push to the branch).
-  Crea un nuevo Pull Request.

## Licencia

Este proyecto está bajo la licencia Apache 2.
