# CRUD API REST

CRUD hecho con JAVA y Spring boot. Apliqué patrones MVC, Repository, IoC, Inyeccion de dependencias, manejo de excepciones, validaciones de datos y Spring Security con Basic Auth. La base de datos es MySql y esta versionado con Git.

## Instalación

### Cloná el repositorio
Primero cloná este repositorio en tu maquina usando este comando:

git clone https://github.com/oliveraluchoo/libreria-crud-api.git

###Abrí el Proyecto en tu Entorno de Desarrollo (IDE)

Abrí tu entorno de desarrollo preferido (puede ser IntelliJ IDEA, NetBeans, Eclipse, Spring Tool Suite, u otro) y seleccioná "Open Project" (Abrir Proyecto) o su equivalente. Navegá hasta la carpeta del proyecto que acabas de clonar y ábrilo.

### Configurá la base de datos

En el archivo application.properties, que se encuentra en la carpeta de recursos del proyecto (src/main/resources/application.properties), tenes que realizar los siguientes ajustes:

spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos?createDatabaseIfNotExist=true
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

Reemplazá tu_base_de_datos, tu_usuario y tu_contraseña con la información correspondiente a tu configuración de MySQL.

## Ejecutá la aplicación

Una vez que hayas configurado la base de datos y guardado los cambios en application.properties, podes ejecutar la aplicación. Busca la clase principal "EmployeeCrudApplication" (etiquetada como @SpringBootApplication) y ejecutala como una aplicación Java en tu entorno de desarrollo.

## Documentación Swagger

Swagger está disponible en: http://localhost:8080/doc/swagger-ui-custom.html

## Autenticación y autorización

Algunos endpoints requieren un usuario con rol ADMIN para su ejecución.
Los endpoints protegidos requieren autenticación mediante Basic Auth.


## Endpoints API

### Crear un Libro (POST)

 - URL: POST http://localhost:8080/api/v1/libros/

 - Rol Requerido: ADMIN

 - Parámetros: Datos del libro en formato JSON (Body)

 - Respuesta:

   - 201: Libro creado con éxito

   - 400 - 500: Error de validación o servidor

Ejemplo de body:

```json
{
  "isbn": "300",
  "titulo": "El Aleph",
  "autor": "Jorge Luis Borges",
  "aniopublicacion": 1949,
  "genero": "Narrativo"
}
```

### Actualizar Un Libro

 - URL: PUT http://localhost:8080/api/v1/libros/{id}

 - Rol Requerido: ADMIN

 - Parámetros:

    - id (long) requerido en la URL

    - Datos actualizados en formato JSON (Body)

 - Respuesta:

    - 200: Libro actualizado correctamente

    - 400 - 500: Error de validación o servidor

###
