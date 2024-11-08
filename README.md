# Hospital Application

Aplicación para la gestión de enfermeras en un hospital, desarrollada en Java y Spring. Esta aplicación permite a los usuarios validar credenciales, consultar la lista de enfermeras, buscar enfermeras por nombre y actualizar los datos de una enfermera.

## Descripción

El proyecto **Hospital Application** tiene como objetivo facilitar la administración de los datos de enfermeras en un entorno hospitalario. La aplicación provee una API que permite gestionar la información de manera eficiente, mejorando el flujo de trabajo y la precisión en la administración de personal de enfermería.

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/HospitalApplication.git

## Uso

ENDPOINTS DE LA API

1. Validación de Login (POST /validateLogin)
Valida las credenciales de acceso.

2. Obtener Todas las Enfermeras (GET /getAll)
Devuelve la lista completa de enfermeras registradas.

3. Crear Enfermera (POST /createNurse)
Crea un enfermero/a a partir de su ID.

4. Buscar Enfermera por Nombre (GET /findByName/{name})
Busca una enfermera específica por nombre.

5. Actualizar Datos de Enfermera (PUT /updateNurse)
Actualiza la información de una enfermera.

6. Eliminar Enfermera (PUT /delete/{id})
Elimina una enfermera específica del sistema por su ID.

7. Obtener Enfermera por ID (GET /read/{id})
Devuelve los datos de una enfermera específica por su ID.

Cada endpoint permite realizar una acción específica para gestionar los datos de enfermeros/as en el sistema de manera eficiente.
