# Hospital Application

Application for managing nurses in a hospital, developed in Java and Spring. This application allows users to validate credentials, consult the list of nurses, search for nurses by name, and update nurse data.

## Description

The **Hospital Application** project aims to facilitate the management of nurse data in a hospital environment. The application provides an API that allows efficient information management, improving workflow and accuracy in nursing staff administration.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/GerardBartalot/M13-Spring-Boot.git

## Usage

API ENDPOINTS

1. Login Validation (POST /validateLogin)
Validates access credentials.

2. Get All Nurses (GET /getAll)
Returns the complete list of registered nurses.

3. Create Nurse (POST /createNurse)
Creates a nurse using their ID.

4. Search Nurse by Name (GET /findByName/{name})
Searches for a specific nurse by name.

5. Update Nurse Data (PUT /updateNurse)
Updates the information of a nurse.

6. Delete Nurse (PUT /delete/{id})
Deletes a specific nurse from the system by their ID.

7. Get Nurse by ID (GET /read/{id})
Returns the data of a specific nurse by their ID.

Each endpoint performs a specific action to efficiently manage nurse data within the system.
