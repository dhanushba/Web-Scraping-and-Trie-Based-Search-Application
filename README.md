# Web Scraping and Trie-Based Search Application

## Overview
The **Web Scraping and Trie-Based Search Application** is a **Spring Boot** project that automates web scraping, extracts data from specified URLs, and enables efficient search functionality using a **Trie data structure**. This project is designed to help users quickly find relevant information from scraped web content.

## Features
✅ **Automated Web Scraping** – Scrape content from user-defined URLs based on keywords.  
✅ **Scheduled or On-Demand Scraping** – Supports both scheduled and real-time scraping.  
✅ **Efficient Trie-Based Search** – Enables fast and accurate keyword searches with prefix matching.  
✅ **RESTful API** – Provides well-structured API endpoints for interaction.  
✅ **Modular & Scalable Design** – Clean code architecture following best practices.  
✅ **Unit Testing** – Includes JUnit test cases to ensure functionality.  

## Technologies Used
- **Java 17+** (Spring Boot Framework)
- **Maven** (Dependency Management)
- **Jsoup** (Web Scraping Library)
- **Spring Scheduler** (Task Scheduling)
- **H2/PostgreSQL** (Database for Storing Scraped Data)
- **JUnit & Mockito** (Unit Testing)

---

## Installation & Setup
### **1. Clone the Repository**
```bash
git clone <repository-url>
cd webscraping_project
```

### **2. Build the Project**
```bash
mvn clean install
```

### **3. Run the Application**
```bash
mvn spring-boot:run
```

### **4. Test API Endpoints Using Postman**
Use **Postman** or **cURL** to interact with the application.

---

## API Endpoints
### **1. Start Web Scraping**
**Endpoint:** `POST /api/v1/scrape`

**Request Body:**
```json
{
  "urls": ["https://example.com/news", "https://example2.com/blog"],
  "keywords": ["technology", "innovation"],
  "schedule": "2024-11-01T10:00:00Z"
}
```

**Response:**
```json
{
  "status": "success",
  "message": "Scraping initiated successfully.",
  "jobId": "12345",
  "scheduledAt": "2024-11-01T10:00:00Z"
}
```

### **2. Search for Keywords**
**Endpoint:** `POST /api/v1/search`

**Request Body:**
```json
{
  "prefix": "tech",
  "limit": 5
}
```

**Response:**
```json
{
  "status": "success",
  "results": [
    {
      "url": "https://example.com/news",
      "matchedContent": "Latest technology trends are shaping the future...",
      "timestamp": "2024-10-29T14:30:00Z"
    },
    {
      "url": "https://example2.com/blog",
      "matchedContent": "The innovation in tech is accelerating...",
      "timestamp": "2024-10-29T12:00:00Z"
    }
  ]
}
```

### **3. Check Scraping Status**
**Endpoint:** `GET /api/v1/status/{jobId}`

**Response:**
```json
{
  "status": "completed",
  "jobId": "12345",
  "urlsScraped": ["https://example.com/news", "https://example2.com/blog"],
  "keywordsFound": ["technology", "innovation"],
  "dataSize": "2 MB",
  "finishedAt": "2024-11-01T10:15:00Z"
}
```

---

## Folder Structure
```plaintext
webscraping_project/
├── src/
│   ├── main/
│   │   ├── java/com/webscraping/
│   │   │   ├── controller/  # API Controllers
│   │   │   ├── service/     # Business Logic
│   │   │   ├── model/       # Data Models
│   │   │   ├── util/        # Utility Classes
│   ├── test/
│   │   ├── java/com/webscraping/ # Unit Tests
├── pom.xml  # Maven Configuration
├── README.md  # Project Documentation
```

---

## Running Unit Tests
To execute test cases, run:
```bash
mvn test
```

---

## Best Practices Followed
✅ **SOLID Principles** – For maintainable and scalable code.  
✅ **Design Patterns** – Applied **Factory**, **Singleton**, and **Strategy patterns** where appropriate.  
✅ **TDD (Test-Driven Development)** – Ensured high test coverage.  
✅ **RESTful API Design** – Proper HTTP methods and status codes.  

---

## License
This project is licensed under the **MIT License**.

---

## Contributors
- **Your Name** – Developer & Maintainer  

For any questions or contributions, feel free to raise an issue or submit a pull request.

🚀 **Happy Coding!** 🚀

