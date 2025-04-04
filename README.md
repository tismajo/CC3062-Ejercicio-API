# Ejercicio API con Spring Boot

## Descripción
Este proyecto es una API REST desarrollada con Java y Spring Boot para gestionar tickets de incidentes. La API permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre los tickets.

## Tecnologías utilizadas
- **Java 21**: Lenguaje de programación principal del proyecto.
- **Spring Boot 3.4.4**: Framework utilizado para el desarrollo de la API REST.
- **Spring Boot DevTools**: Dependencia para mejorar la experiencia de desarrollo mediante recarga automática de cambios.
- **Spring Web**: Módulo de Spring Boot para construir aplicaciones web y servicios REST.
- **Spring Data JPA**: Para la gestión de persistencia con la base de datos.
- **MySQL**: Base de datos utilizada para almacenar los tickets.
- **Postman**: Herramienta para probar y consumir los endpoints de la API.

## Requisitos previos
Para ejecutar este proyecto en tu entorno local, debes tener instalado:

1. **Java 21**
2. **Maven** (gestor de dependencias)
3. **MySQL** (base de datos relacional)
4. **Postman** (opcional, para probar los endpoints)

## Instalación y configuración
### 1. Clonar el repositorio
```sh
 git clone https://github.com/tu-repositorio/EjercicioAPI.git
 cd EjercicioAPI
```

### 2. Configurar la base de datos
Crear la base de datos en MySQL:
```sql
CREATE DATABASE ticketSystem;
USE ticketSystem;

CREATE TABLE Ticket (
    id INT PRIMARY KEY AUTO_INCREMENT,
    reporter VARCHAR(255),
    description TEXT,
    status VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

Configurar el archivo `application.properties` en `src/main/resources/`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ticketSystem
spring.datasource.username=root  # Cambiar según configuración local
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Ejecutar el proyecto
```sh
mvn spring-boot:run
```
La API estará disponible en `http://localhost:8080`

## Estructura del Proyecto
```
com.UVG.EjercicioAPI
│
├── Controller
│   ├── TicketController.java  # Controlador REST para gestionar tickets
│
├── Model
│   ├── TicketModel.java       # Modelo de datos para los tickets
│
├── Repository
│   ├── TicketRepository.java  # Interfaz JPA para la persistencia
│
├── DTO
│   ├── StatusUpdateDTO.java   # DTO para actualizar estado
│
├── resources
│   ├── application.properties # Configuración de la aplicación
```

## Endpoints Disponibles

### Crear un ticket
- **URL:** `/tickets/incidents`
- **Método:** `POST`
- **Cuerpo de la solicitud:**
  ```json
  {
    "reporter": "Juan Perez",
    "description": "Problema con el sistema",
    "status": "Abierto"
  }
  ```
- **Respuesta:** Ticket creado

### Obtener todos los tickets
- **URL:** `/tickets/incidents`
- **Método:** `GET`
- **Respuesta:** Lista de tickets registrados

### Obtener un ticket por ID
- **URL:** `/tickets/incidents/{id}`
- **Método:** `GET`
- **Respuesta:** Detalles del ticket solicitado

### Actualizar estado de un ticket
- **URL:** `/tickets/incidents/{id}`
- **Método:** `PUT`
- **Cuerpo de la solicitud:**
  ```json
  {
    "status": "Cerrado"
  }
  ```
- **Respuesta:** Ticket actualizado

### Eliminar un ticket
- **URL:** `/tickets/incidents/{id}`
- **Método:** `DELETE`
- **Respuesta:** Confirmación de eliminación

## Pruebas con Postman
Puedes importar la siguiente colección de Postman para probar los endpoints de la API:
- [Colección de Postman](#) (colocar enlace al archivo JSON de la colección si se tiene)

## Autor
Desarrollado por **María José Girón Isidro**
