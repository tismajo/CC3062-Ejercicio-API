# Ejercicio API con Spring Boot

## Descripción
Este proyecto es una API REST desarrollada con Java y Spring Boot que permite gestionar tickets de incidentes. Proporciona endpoints para la creación, consulta, actualización y eliminación de tickets.

## Tecnologías utilizadas
- **Java**: Lenguaje de programación principal del proyecto.
- **Spring Boot**: Framework utilizado para el desarrollo de la API REST.
- **Spring Boot DevTools**: Dependencia para mejorar la experiencia de desarrollo mediante recarga automática de cambios.
- **Spring Web**: Módulo de Spring Boot para construir aplicaciones web y servicios REST.

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
    "id": 1,
    "reporter": "Juan Perez",
    "description": "Problema con el sistema",
    "status": "Abierto",
    "created_at": "2024-03-27"
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
  "Cerrado"
  ```
- **Respuesta:** Ticket actualizado

### Eliminar un ticket
- **URL:** `/tickets/incidents/{id}`
- **Método:** `DELETE`
- **Respuesta:** Confirmación de eliminación

La API estará disponible en `http://localhost:8080`

## Autor
Desarrollado por **María José Girón Isidro**

