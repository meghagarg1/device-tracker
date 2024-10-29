

Device Tracker API
A Restful API built with Spring Boot for managing devices, allowing CRUD operations and brand-based search functionality. 
This API is designed to handle device records by allowing clients to add, retrieve, update, delete, and search devices by brand.

Prerequisites
Java 
Maven 
IDE like IntelliJ or Eclipse for local development
Docker 

Clone the Repository
Go to project folder:

docker build -t my-device-tracker .
docker run -p 8080:8080 my-device-tracker
The application should start on http://localhost:8080.
Once the application is running, access the Swagger UI at:
http://localhost:8080/swagger-ui.html

Alternatively:
Build the Project:
mvn clean install
Run the Application:
mvn spring-boot:run
The application should start on http://localhost:8080.
Once the application is running, access the Swagger UI at:
http://localhost:8080/swagger-ui.html


Endpoints
HTTP Method	Endpoint	Description
POST	/api/devices	Add a new device
GET	/api/devices/{id}	Get a device by ID
GET	/api/devices	List all devices
PUT	/api/devices/{id}	Update a device by ID
DELETE	/api/devices/{id}	Delete a device by ID
GET	/api/devices/search	Search devices by brand
API Documentation
This API is documented using Swagger, which provides a user-friendly UI to interact with the API and view request/response examples.

Technologies Used
Spring Boot: Framework for building the application.
Spring Data JPA: To interact with the database.
Swagger: For API documentation.
