#  Device Tracker API

A RESTful API built with **Spring Boot** for managing devices, enabling CRUD operations and brand-based search functionality. This API allows clients to **add**, **retrieve**, **update**, **delete**, and **search devices by brand**.

---

## Prerequisites

- **Java**
- **Maven**
- **IDE** (e.g., IntelliJ or Eclipse for local development)
- **Docker**

---

## ⚙️ Installation

### Clone the Repository
```bash
git clone https://github.com/meghagarg1/device-tracker.git
```

```
cd device-tracker
```

### Running with Docker

1. **Build the Docker image**:
   ```bash
   docker build -t my-device-tracker .
   ```

2. **Run the Docker container**:
   ```bash
   docker run -p 8080:8080 my-device-tracker
   ```

3. The application should start on **[http://localhost:8080](http://localhost:8080)**.

4. Access the Swagger UI for API documentation at **[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)**.

### Running without Docker

1. **Build the project**:
   ```bash
   mvn clean install
   ```

2. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

3. Access the application on **[http://localhost:8080](http://localhost:8080)** and the Swagger UI at **[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)**.

---

## 📋 Endpoints

| HTTP Method | Endpoint              | Description                  |
|-------------|-----------------------|------------------------------|
| `POST`      | `/api/devices`        | Add a new device             |
| `GET`       | `/api/devices/{id}`   | Get a device by ID           |
| `GET`       | `/api/devices`        | List all devices             |
| `PUT`       | `/api/devices/{id}`   | Update a device by ID        |
| `DELETE`    | `/api/devices/{id}`   | Delete a device by ID        |
| `GET`       | `/api/devices/search` | Search devices by brand      |

---

## 📑 API Documentation

This API is documented using **Swagger**, offering an interactive interface to test endpoints and view example requests and responses. Access it at **[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)**.

---

## 🛠 Technologies Used

- **Spring Boot**: Framework for application development.
- **Spring Data JPA**: Database interaction.
- **Swagger**: API documentation and testing.

---

This README file should give users a clean overview of your API and its setup process. Let me know if you need further customization!
