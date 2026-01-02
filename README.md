# Car Management & Fuel Tracking
A simple Java Spring Boot application with a CLI client that allows users to manage cars, track fuel usage, and calculate fuel statistics.
## Features

- Add a new car (brand, model, year)
- Record fuel entries for a car (liters, price, odometer)
- View fuel statistics (total fuel, total cost, average consumption)
- Access fuel statistics via:
  - REST API endpoints
  - Manual servlet
- Use CLI client to interact with the backend
## Tech Stack

- Java 17
- Spring Boot (REST API, Servlet)
- Maven
- CLI application using java.net.http.HttpClient
- In-memory storage (Lists/Maps)

  ## Getting Started

### Backend

1. Navigate to the `carmanagement` folder
2. Build and run:
   ```bash
   mvn spring-boot:run
3.	API runs at: http://localhost:8080
### CLI Application
1.	Navigate to the cli folder
2.	bash
     mvn compile
3.	Run commands:
   
           - java -cp target/classes com.brenda.Main create-car --brand Toyota --model Corolla --year 2018
           - java -cp target/classes com.brenda.Main add-fuel --carId 1 --liters 40 --price 52.5 --odometer 45000
           - java -cp target/classes com.brenda.Main fuel-stats --carId 1

---

## 5️⃣ API Endpoints / CLI Commands

### REST API

### REST API Endpoints

| Method | Endpoint | Description | Request Body |
|--------|---------|------------|--------------|
| POST   | /api/cars | Add a new car | { "brand": "Toyota", "model": "Corolla", "year": 2018 } |
| GET    | /api/cars | List all cars | N/A |
| POST   | /api/cars/{id}/fuel | Add fuel entry | { "liters": 40, "price": 52.5, "odometer": 45000 } |
| GET    | /api/cars/{id}/fuel/stats | Fuel statistics | N/A |

### Servlet Endpoint
| Method | Endpoint | Description |
|--------|---------|------------|
| GET    | /servlet/fuel-stats?carId=1 | Fuel statistics via manual servlet |
---

## 6️⃣ Screenshots 

1. **Backend running in VS Code / terminal**  

<img width="1353" height="244" alt="Screenshot 2026-01-02 at 9 19 38 PM" src="https://github.com/user-attachments/assets/425425ea-4b52-47be-9325-f82064e67a35" />

2. **Testing REST endpoints (Postman)**  
 <table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/2dac9e1c-003f-419c-9709-29f801ee6015" width="300" /></td>
    <td><img src="https://github.com/user-attachments/assets/2dac9e1c-003f-419c-9709-29f801ee6015" width="300" /></td>
    <td><img src="https://github.com/user-attachments/assets/2dac9e1c-003f-419c-9709-29f801ee6015" width="300" /></td>
  </tr>
</table>
3. **CLI output**  
    <img width="1410" height="233" alt="Screenshot 2026-01-02 at 8 57 47 PM" src="https://github.com/user-attachments/assets/90301e7b-31d2-4c58-9c1e-ba30b2535667" />

## Project Structure

      
      ├── src/main/java/com/example/carmanagement
      │   ├── controller/
      │   ├── model/
      │   ├── service/
      │   ├── servlet/
      │   └── config/
      └── pom.xml
      
      cli/
      ├── src/main/java/com/example/carcli
      │   └── Main.java
      └── pom.xml


## License
MIT


 
