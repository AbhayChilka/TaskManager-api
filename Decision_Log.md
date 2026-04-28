# DECISION LOG — Smart Task Manager API

## 1. Time Breakdown

Total time spent: ~4.5 hours

- Project setup (Spring Boot + structure): ~30 minutes  
- Core API implementation (POST, GET, PATCH): ~1.5 hours  
- Debugging and fixing issues (Lombok, JSON mapping): ~45 minutes  
- Smart feature (auto-priority suggestion): ~1–1.5 hours  
- Testing using Postman: ~30–45 minutes  
- Writing DECISION_LOG.md and cleanup: ~45 minutes  

---

## 2. Where AI Was Used — and Why

AI assistance was used in a controlled and intentional manner:

- Generating initial Spring Boot structure (controller, service, repository layers)
- Suggesting improvements for REST API design (ResponseEntity usage, HTTP status codes)
- Debugging issues related to Lombok and JSON deserialization
- Designing and refining the smart feature (auto-priority suggestion logic)
- Identifying common pitfalls (e.g., incorrect PATCH handling, repository ID logic)

Reason:
AI was used to accelerate development for standard and repetitive tasks, allowing more focus on core logic and decision-making.

---

## 3. Where AI Was NOT Used — and Why

AI was intentionally not used for:

- Core API design decisions (choosing endpoints and structure)
- Business logic implementation (task creation, status updates)
- Data storage approach (decision to use in-memory storage)
- Trade-off decisions under time constraints

Reason:
These areas represent fundamental backend concepts, and implementing them manually ensured correctness and understanding.

---

## 4. Bad AI Outputs (Required)

### Case 1: Over-engineered Architecture

AI suggested introducing additional layers such as DTOs and mappers.

Issue:
This added unnecessary complexity for a simple assignment and violated the constraint of keeping the solution minimal.

Fix:
Simplified the architecture to a clean controller → service → repository structure.

---

### Case 2: Incorrect PATCH Logic

AI initially suggested replacing the entire task object for the PATCH endpoint.

Issue:
PATCH should perform partial updates. Replacing the entire object could lead to data loss.

Fix:
Modified the implementation to update only the `status` field while preserving existing data.

---

## 5. Trade-offs Made

### What was NOT implemented:

- Database integration (used in-memory storage instead)
- Authentication/authorization
- Advanced validation framework

### Why:

- Time constraint (4–6 hours) required prioritizing core functionality
- Assignment explicitly allows lightweight persistence
- Focused on delivering a clean, working API with one well-implemented smart feature

---

### Shortcuts taken:

- Used keyword-based logic instead of real AI/LLM integration
- Basic exception handling using RuntimeException

### Justification:

- Ensured faster implementation within time constraints
- Demonstrated intent of AI-based feature without overcomplicating the system

---

## 6. Smart Feature Chosen — Auto Priority Suggestion

### Reason for choosing:

- Feasible to implement within limited time
- Clearly demonstrates AI-assisted decision-making
- Easy to explain and validate

### Implementation:

- Combined task title and description
- Applied keyword-based analysis:
  - "urgent", "critical", "asap" → HIGH
  - "optional", "later" → LOW
  - Default → MEDIUM

### Output:

- `priority` field (LOW / MEDIUM / HIGH)
- `priorityReason` explaining the decision

---

## 7. What I Would Improve With More Time

Given additional time, I would:

- Integrate a real AI/LLM API for smarter priority detection
- Add persistent storage (e.g., Mongodb, h2 or PostgreSQL)
- Implement proper validation using annotations (`@NotBlank`, etc.)

---

## 8. Reflection

- Focused on delivering a working solution within the time constraint rather than over-engineering
- Used AI as a productivity tool while maintaining control over logic and decisions
