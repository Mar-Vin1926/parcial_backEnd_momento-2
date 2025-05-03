# API RESTful para la Gestión de Sucursales

Este proyecto implementa una API RESTful utilizando Spring Boot y MySQL para la gestión de información de sucursales. Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre la entidad `Sucursal`.

## Tecnologías Utilizadas

* **Java:** Lenguaje de programación principal.
* **Spring Boot:** Framework de desarrollo de aplicaciones Java.
* **Spring Data JPA:** Facilita la interacción con la base de datos.
* **MySQL:** Base de datos relacional utilizada para el almacenamiento de datos.
* **(Opcional) Lombok:** Biblioteca para reducir el código boilerplate (si lo estás usando).
* **Maven:** Herramienta de gestión de dependencias y construcción.
* **Postman/EchoAPI:** Herramientas utilizadas para probar la API.

## Requisitos Previos

Antes de ejecutar la aplicación, asegúrate de tener instalado y configurado lo siguiente:

* **Java Development Kit (JDK) 17 o superior.**
* **Maven:** La aplicación utiliza Maven para la gestión de dependencias y la construcción.
* **MySQL:** Una instancia de MySQL en ejecución. Asegúrate de tener las credenciales de acceso (usuario y contraseña) y una base de datos creada para el proyecto.
* **(Opcional) Plugin de Lombok** en tu IDE (si estás utilizando Lombok).

## Configuración de la Base de Datos

La configuración de la conexión a la base de datos se realiza a través de variables de entorno del sistema operativo. Debes configurar las siguientes variables en tu entorno antes de ejecutar la aplicación:
.env/
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/sucursal_db?serverTimezone=America/Bogota
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=root
SPRING_DATASOURCE_DRIVER_CLASS_NAME=com.mysql.cj.jdbc.Driver
SPRING_JPA_HIBERNATE_DDL_AUTO=update
SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT=org.hibernate.dialect.MySQL8Dialect   

## Instrucciones de Uso

1.  **Clonar el Repositorio:**
    ```bash
    git clone https://github.com/Mar-Vin1926/parcial_backEnd_momento-2.git
    cd tu_proyecto
    ```

2.  **Configurar las Variables de Entorno:** Asegúrate de configurar las variables de entorno mencionadas en la sección "Configuración de la Base de Datos" en tu sistema operativo.

3.  **Ejecutar la Aplicación Spring Boot:**
    * **Desde la línea de comandos (Terminal/CMD):** Navega hasta la raíz del proyecto (donde se encuentra el archivo `pom.xml`) y ejecuta el siguiente comando:
        ```bash
        ./mvnw spring-boot:run
        ```
        (En Windows, usa `mvnw.cmd spring-boot:run`).
    * **Desde tu IDE (Visual Studio Code, IntelliJ, etc.):** Ejecuta la clase principal de la aplicación (`DemoApplication.java`).

4.  **Probar la API:** Una vez que la aplicación se haya iniciado (busca el mensaje "Started DemoApplication..." en la consola), puedes probar los diferentes endpoints de la API utilizando Postman o EchoAPI.

    * **Base URL:** `http://localhost:8080/api/sucursales`

    * **Endpoints:**
        * `POST /api/sucursales`: Crea una nueva sucursal (requiere un objeto JSON en el cuerpo).
        * `GET /api/sucursales`: Obtiene la lista de todas las sucursales.
        * `GET /api/sucursales/{id}`: Obtiene una sucursal por su ID. Reemplaza `{id}` con el ID de la sucursal.
        * `PUT /api/sucursales/{id}`: Actualiza una sucursal existente (requiere un objeto JSON en el cuerpo). Reemplaza `{id}` con el ID de la sucursal a actualizar.
        * `DELETE /api/sucursales/{id}`: Elimina una sucursal por su ID. Reemplaza `{id}` con el ID de la sucursal a eliminar.

    * **Ejemplos de Body (para POST y PUT):**
        ```json
        {
            "nombre": "Nombre de la Sucursal",
            "direccion": "Dirección de la Sucursal",
            "numeroTelefono": "Número de Teléfono"
        }
        ```

## Entidades

La aplicación gestiona la entidad `Sucursal` con los siguientes atributos:

* `id` (Long): Identificador único de la sucursal (generado automáticamente).
* `nombre` (String): Nombre de la sucursal (obligatorio).
* `direccion` (String): Dirección de la sucursal (obligatorio).
* `numeroTelefono` (String): Número de teléfono de la sucursal (opcional).
