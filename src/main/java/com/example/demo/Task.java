package com.example.demo;

import java.util.Objects;

/**
 * Represents a task with a text description and a completion flag.
 */
public class Task {

    private final String description;
    private boolean done;

    /**
     * Creates a new task with the supplied description.
     * The task is initially not done.
     *
     * @param description the task description, must not be null or blank
     */
    public Task(String description) {
        Objects.requireNonNull(description, "description must not be null");
        if (description.isBlank()) {
            throw new IllegalArgumentException("description must not be blank");
        }
        this.description = description;
        this.done = false;
    }

    /**
     * Returns the text description for this task.
     *
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns whether the task is marked as done.
     *
     * @return true if the task is done, false otherwise
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Marks the task as done or undone.
     *
     * @param done true to mark the task as done, false to mark it as not done
     */
    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Task)) {
            return false;
        }
        Task task = (Task) o;
        return done == task.done && description.equals(task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, done);
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", done=" + done +
                '}';
    }
}
