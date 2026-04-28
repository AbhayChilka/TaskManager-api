SMART TASK MANAGER API

A simple backend API for managing tasks, built using Java and Spring
Boot. This project focuses on clean design, fast execution, and smart
decision-making under time constraints.

FEATURES

Core Functionality: - Create a new task - Mark a task as completed -
Retrieve all tasks

Smart Feature (AI-Inspired): - Auto Priority Suggestion - Assigns
priority (LOW, MEDIUM, HIGH) - Based on keywords in title and
description - Provides reasoning for assigned priority

TECH STACK

-   Java 17+
-   Spring Boot
-   Lombok
-   In-memory storage (HashMap)

PROJECT STRUCTURE

taskmanager/ 
|– controller/ (REST APIs) 
|– service/ (Business logic) 
|– repository/ (In-memory storage) 
|– model/ (Entities & enums) 
|– ai/(Smart feature logic) |– TaskManagerApplication.java

API ENDPOINTS

1.  Create Task POST /tasks

2.  Get All Tasks GET /tasks

3.  Mark Task as Completed PATCH /tasks/{id}

HOW TO RUN

1.  Clone repository: git clone cd TaskManager-api

2.  Run application: ./mvnw spring-boot:run

3.  Test APIs using Postman or cURL

DESIGN DECISIONS

-   Used in-memory storage for simplicity and speed
-   Avoided over-engineering
-   Focused on core functionality within time constraints

See - [DECISION_LOG.md](DECISION_LOG.md) for:

Time breakdown
AI usage
Trade-offs
Improvements

