package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Manages a list of tasks in-memory.
 *
 * <p>This class supports adding tasks, reading the current task list, and marking
 * tasks as done by description.</p>
 */
public class TaskManager {

    private final List<Task> tasks = new ArrayList<>();

    /**
     * Adds a new task with the provided description.
     *
     * @param description the text description of the new task, must not be null or blank
     * @return the created task
     */
    public Task addTask(String description) {
        validateDescription(description);
        Task task = new Task(description);
        tasks.add(task);
        return task;
    }

    /**
     * Returns the current list of tasks.
     *
     * <p>The returned list is unmodifiable to prevent external callers from
     * mutating the manager's internal task list.</p>
     *
     * @return an unmodifiable list of tasks
     */
    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    /**
     * Returns all tasks whose description exactly matches the provided text.
     *
     * @param description the description to search for, must not be null or blank
     * @return an unmodifiable list of matching tasks
     */
    public List<Task> findTasks(String description) {
        validateDescription(description);
        return tasks.stream()
                .filter(task -> task.getDescription().equals(description))
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Returns all tasks that are not yet marked as done.
     *
     * @return an unmodifiable list of pending tasks
     */
    public List<Task> getPendingTasks() {
        return tasks.stream()
                .filter(task -> !task.isDone())
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Returns all tasks that have been marked done.
     *
     * @return an unmodifiable list of completed tasks
     */
    public List<Task> getCompletedTasks() {
        return tasks.stream()
                .filter(Task::isDone)
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Marks the first task with the matching description as done.
     *
     * @param description the description to search for, must not be null or blank
     * @return true if a matching task was found and marked done, false otherwise
     */
    public boolean markAsDone(String description) {
        validateDescription(description);
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                task.setDone(true);
                return true;
            }
        }
        return false;
    }

    /**
     * Removes all tasks whose description matches the provided value.
     *
     * @param description the description to remove, must not be null or blank
     * @return true if any tasks were removed, false otherwise
     */
    public boolean removeTask(String description) {
        validateDescription(description);
        return tasks.removeIf(task -> task.getDescription().equals(description));
    }

    private static void validateDescription(String description) {
        Objects.requireNonNull(description, "description must not be null");
        if (description.isBlank()) {
            throw new IllegalArgumentException("description must not be blank");
        }
    }
}
