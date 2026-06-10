# AI Generated Image Detection System

The AI Generated Image Detection System is a web-based application that allows users to upload images and determine whether they are AI-generated or real. The system combines a Spring Boot web application with a Python Flask AI service to process uploaded images and provide prediction results along with confidence scores.

The project demonstrates the integration of Java-based web development with Python-based AI processing, creating a full-stack AI-powered application.

---

## Features

### User Features

* Upload images through a web interface.
* Detect whether an image is AI-generated or real.
* Display prediction results with confidence scores.
* Simple and user-friendly interface with a Lavender & White theme.
* Support for common image formats (JPG, JPEG, PNG).

### System Features

* Spring Boot backend for handling web requests.
* Python Flask API for image analysis.
* MySQL database integration.
* REST communication between Java and Python services.
* Responsive and modern user interface.

---

## System Architecture

The application follows a three-tier architecture:

| Layer       | Role                                                                                                                          |
| ----------- | ----------------------------------------------------------------------------------------------------------------------------- |
| Client      | Web browser interface where users upload images and view detection results.                                                   |
| Application | Spring Boot handles image uploads and communicates with the Flask AI service. Flask processes images and returns predictions. |
| Database    | MySQL stores application-related data and configurations.                                                                     |

### Workflow

User Uploads Image
↓
Spring Boot Application
↓
Python Flask AI Service
↓
AI Prediction
↓
Spring Boot Receives Result
↓
Display Result to User

---

## Tech Stack

### Backend

* Java 17
* Spring Boot
* Spring MVC
* Thymeleaf

### AI Service

* Python
* Flask
* Flask-CORS
* Pillow

### Database

* MySQL

### Frontend

* HTML
* CSS
* Thymeleaf Templates

### Tools

* IntelliJ IDEA
* MySQL Workbench
* Git
* GitHub

---

## Prerequisites

Before running the project, ensure the following software is installed:

* Java 17 or higher
* Python 3.10 or higher
* MySQL Server
* MySQL Workbench
* Maven
* Git
* IntelliJ IDEA

---

## Database Setup

### Create Database

Open MySQL Workbench and execute:

```sql
CREATE DATABASE ai_detector;
```

Update the database configuration in:

```properties
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ai_detector
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Python AI API Setup

Navigate to the Python service directory:

```bash
cd python-ai-api
```

Install dependencies:

```bash
pip install -r requirements.txt
```

Run the Flask server:

```bash
python app.py
```

The API will start on:

```text
http://localhost:5000
```

---

## Spring Boot Setup

Open the project in IntelliJ IDEA.

Run:

```text
AiImageDetectorApplication.java
```

Or use Maven:

```bash
./mvnw spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

---

## Running the Application

### Step 1

Start the Python Flask API:

```bash
python app.py
```

### Step 2

Start the Spring Boot application:

```text
Run AiImageDetectorApplication
```

### Step 3

Open your browser:

```text
http://localhost:8080
```

### Step 4

Upload an image and view the detection result.

---

## Usage Overview

### User Workflow

1. Open the web application.
2. Upload an image.
3. Submit the image for analysis.
4. The system sends the image to the Flask AI service.
5. The AI service analyzes the image.
6. Prediction results and confidence score are displayed.

---

## Future Enhancements

* Integration of advanced pre-trained AI detection models.
* User authentication and login system.
* Detection history storage.
* Support for multiple image uploads.
* Dashboard with analytics and reports.
* Cloud deployment support.

---


