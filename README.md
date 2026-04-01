# 🚀 Hoen Scanner Microservice

Hoen Scanner is a lightweight **Java microservice** built using the **Dropwizard framework**. It provides search functionality for hotels and car rentals based on a given city.

---

## 🧠 Features

* 🔍 Search hotels and rental cars by city
* ⚡ Fast in-memory filtering
* 📦 JSON-based request & response
* 🧩 Built using microservice architecture principles

---

## 🏗️ Tech Stack

* Java (JDK 19)
* Dropwizard
* Maven
* Jackson (JSON processing)
* Postman (API testing)

---

## 📁 Project Structure

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

## ⚙️ Prerequisites

Make sure you have installed:

* Java JDK 19
* Maven
* Git
* IntelliJ IDEA (recommended)
* Postman (for testing)

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Ahmedkhan78/host-scanner.git
cd hoen-scanner
```

---

### 2. Build the Project

```bash
mvn clean install
```

---

### 3. Run the Application

```bash
java -jar target/hoen-scanner-1.0-SNAPSHOT.jar server config.yml
```

---

## 🌐 Application URLs

| Service     | URL                   |
| ----------- | --------------------- |
| API Server  | http://localhost:8080 |
| Admin Panel | http://localhost:8081 |

You should see:

```
========================================
Welcome to Hoen Scanner!
========================================
```

---

## 📡 API Usage

### 🔎 Search Endpoint

**POST** `/search`

### Request Body

```json
{
  "city": "petalborough"
}
```

---

### ✅ Response Example

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

## 🧪 Testing with Postman

1. Open Postman
2. Set method to **POST**
3. Enter URL:

   ```
   http://localhost:8080/search
   ```
4. Go to **Body → Raw → JSON**
5. Add:

```json
{
  "city": "petalborough"
}
```

6. Click **Send**

---

## 📍 Supported Cities

* petalborough
* rustburg
* shaleport

Invalid city → returns empty array `[]`

---

## 🧩 How It Works

1. Loads data from:

   * `hotels.json`
   * `rental_cars.json`
2. Combines both into a single list
3. Filters results based on user input (`city`)
4. Returns matching results as JSON

---

## 📌 Notes

* Uses **Jackson** for serialization/deserialization
* Dropwizard handles routing and server setup
* Designed as a simple example of **microservice architecture**

---

## 👨‍💻 Author

**Ahmed Khan**

* GitHub: https://github.com/Ahmedkhan78

---

## ⭐ Future Improvements

* Add query validation (empty/null city)
* Add pagination
* Add logging & error handling
* Connect to database instead of static JSON

---
