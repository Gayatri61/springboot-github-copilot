package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    @Test
    void addTask_shouldAddTaskWithDescriptionAndNotDone() {
        TaskManager manager = new TaskManager();

        manager.addTask("Write unit tests");

        List<Task> tasks = manager.getTasks();
        assertEquals(1, tasks.size());
        Task task = tasks.get(0);
        assertEquals("Write unit tests", task.getDescription());
        assertFalse(task.isDone());
    }

    @Test
    void getTasks_shouldReturnUnmodifiableList() {
        TaskManager manager = new TaskManager();
        manager.addTask("Immutable task");

        List<Task> tasks = manager.getTasks();

        assertThrows(UnsupportedOperationException.class, () -> tasks.add(new Task("Should fail")));
    }

    @Test
    void markAsDone_shouldReturnTrueWhenTaskFound() {
        TaskManager manager = new TaskManager();
        manager.addTask("Complete homework");

        boolean result = manager.markAsDone("Complete homework");

        assertTrue(result);
        List<Task> tasks = manager.getTasks();
        assertTrue(tasks.get(0).isDone());
    }

    @Test
    void markAsDone_shouldReturnFalseWhenTaskNotFound() {
        TaskManager manager = new TaskManager();
        manager.addTask("Buy groceries");

        boolean result = manager.markAsDone("Go jogging");

        assertFalse(result);
        List<Task> tasks = manager.getTasks();
        assertFalse(tasks.get(0).isDone());
    }

    @Test
    void addTask_shouldThrowWhenDescriptionIsNull() {
        TaskManager manager = new TaskManager();

        assertThrows(NullPointerException.class, () -> manager.addTask(null));
    }

    @Test
    void markAsDone_shouldThrowWhenDescriptionIsNull() {
        TaskManager manager = new TaskManager();

        assertThrows(NullPointerException.class, () -> manager.markAsDone(null));
    }

    @Test
    void removeTask_shouldRemoveTaskWithMatchingDescription() {
        TaskManager manager = new TaskManager();
        manager.addTask("Task to remove");

        manager.removeTask("Task to remove");

        List<Task> tasks = manager.getTasks();
        assertTrue(tasks.isEmpty());
    }
}