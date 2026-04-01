# Hoen Scanner Microservice

Hoen Scanner is a lightweight Java microservice built using the Dropwizard framework. It provides search functionality for hotels and car rentals based on a given city.

---

## Features

* Search hotels and rental cars by city
* Fast in-memory filtering
* JSON-based request and response handling
* Demonstrates microservice architecture principles

---

## Tech Stack

* Java (JDK 19)
* Dropwizard
* Maven
* Jackson (for JSON processing)
* Postman (for API testing)

---

## Project Structure

```
hoen-scanner/
├── src/main/java/com/skyscanner/
│   ├── HoenScannerApplication.java
│   ├── HoenScannerConfiguration.java
│   ├── Search.java
│   ├── SearchResult.java
│   └── SearchResource.java
├── src/main/resources/
│   ├── config.yml
│   ├── rental_cars.json
│   └── hotels.json
├── pom.xml
└── README.md
```

---

## Prerequisites

Ensure the following are installed:

* Java JDK 19
* Maven
* Git
* IntelliJ IDEA (recommended)
* Postman

---

## Setup and Run

### 1. Clone the repository

```bash
git clone https://github.com/Ahmedkhan78/host-scanner.git
cd hoen-scanner
```

---

### 2. Build the project

```bash
mvn clean install
```

---

### 3. Run the application

```bash
java -jar target/hoen-scanner-1.0-SNAPSHOT.jar server config.yml
```

---

## Application URLs

| Service     | URL                   |
| ----------- | --------------------- |
| API Server  | http://localhost:8080 |
| Admin Panel | http://localhost:8081 |

On successful startup, the following message appears in logs:

```
Welcome to Hoen Scanner!
```

---

## API Endpoint

### POST `/search`

Searches for hotels and rental cars based on a city.

### Request Body

```json
{
  "city": "petalborough"
}
```

---

### Response Example

```json
[
  {
    "city": "petalborough",
    "kind": "hotel",
    "title": "Grand Hotel"
  },
  {
    "city": "petalborough",
    "kind": "car",
    "title": "City Rental Cars"
  }
]
```

---

## Testing with Postman

1. Open Postman
2. Set method to POST
3. Enter URL: `http://localhost:8080/search`
4. Navigate to Body → Raw → JSON
5. Enter:

```json
{
  "city": "petalborough"
}
```

6. Click Send

---

## Supported Cities

* petalborough
* rustburg
* shaleport

Invalid city returns an empty array.

---

## How It Works

* Loads data from `hotels.json` and `rental_cars.json`
* Combines both datasets into a single list
* Filters results based on the requested city
* Returns matching results in JSON format

---

## Notes

* Jackson is used for serialization and deserialization
* Dropwizard handles routing and server configuration
* Designed as a simple demonstration of microservice architecture

---

## Author

Ahmed Khan
GitHub: https://github.com/Ahmedkhan78

---

## Future Improvements

* Input validation for requests
* Pagination support
* Improved error handling
* Database integration instead of static JSON
