# Spring Boot Demo Project

This is a demo Spring Boot project created with Java 17 and Maven. It includes a task management system for creating and tracking tasks.

## Prerequisites

- Java 17
- Maven 3.6+

## Running the Application

To run the application, use the following command:

```bash
mvn spring-boot:run
```

The application will start on http://localhost:8080

## Features

### Task Management System

The project includes a simple in-memory task management system with the following components:

#### Task Class
Represents a single task with:
- **description**: immutable text description of the task
- **done**: boolean flag indicating task completion status

#### TaskManager Class
Manages a collection of tasks with methods to:
- `addTask(String description)` - Creates and adds a new task
- `getTasks()` - Returns all tasks as an unmodifiable list
- `findTasks(String description)` - Find tasks by exact description match
- `getPendingTasks()` - Get all incomplete tasks
- `getCompletedTasks()` - Get all completed tasks
- `markAsDone(String description)` - Mark the first matching task as done
- `removeTask(String description)` - Remove all tasks matching the description

**Features:**
- Input validation (null and blank checks)
- Immutable task list access to prevent external mutations
- Stream-based query methods for filtering tasks
- Equals and hashCode implementation for task comparison

### REST API

- GET / : Returns "Hello World!"

## Building

```bash
mvn compile
mvn test
mvn package
```

## Testing

Run the unit tests with:

```bash
mvn test
```

The test suite includes tests for:
- Adding tasks
- Retrieving task lists
- Marking tasks as done
- Removing tasks
- Input validation and null handling

## Project Structure

```
src/
├── main/java/com/example/demo/
│   ├── DemoApplication.java       # Spring Boot application entry point
│   ├── HelloController.java       # REST controller with Hello World endpoint
│   ├── Task.java                  # Task model class
│   └── TaskManager.java           # Task management service
└── test/java/com/example/demo/
    └── TaskManagerTest.java       # Unit tests for TaskManager
```