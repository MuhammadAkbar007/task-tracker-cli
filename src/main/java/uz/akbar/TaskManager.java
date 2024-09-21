package uz.akbar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TaskManager
 */
public class TaskManager {

	private static final String FILE_PATH = "data/tasks.json";
	private List<Task> tasks;

	public TaskManager() {
		tasks = new ArrayList<>();
		loadTasks();
	}

	/* Load tasks from JSON file */
	private void loadTasks() {
		try {
			File file = new File(FILE_PATH);

			if (file.exists()) {
				String json = new String(Files.readAllBytes(Paths.get(FILE_PATH)));

				if (!json.trim().isEmpty()) {
					tasks = Arrays.stream(json.split("\n"))
							.map(Mapper::fromJson)
							.collect(Collectors.toList());
				}

			} else {
				new File("data").mkdirs();
				new File(FILE_PATH).createNewFile();
			}

		} catch (Exception e) {
			System.out.println("Error loading tasks 🚛:\n" + e.getMessage());
		}
	}

	/* Save tasks to JSON file */
	private void saveTasks() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {

			for (Task task : tasks) {
				writer.write(Mapper.toJson(task));
				writer.newLine();
			}

		} catch (Exception e) {
			System.out.println("Error while saving tasks 📥:\n" + e.getMessage());
		}
	}

	/* Add a new task */
	public void addTask(String description) {
		int id = 0;

		if (tasks.size() > 0) {
			id = tasks.get(tasks.size() - 1).getId() + 1;
		} else {
			id = 1;
		}

		Task task = new Task(id, description, Status.TODO, LocalDateTime.now(), LocalDateTime.now());
		tasks.add(task);
		saveTasks();

		System.out.println("Task added successfully ✅ (ID: " + id + ")");
	}

	/* Update an existing task */
	public void updateTask(int id, String newDescription) {
		Task task = findTaskById(id);

		if (task != null) {
			task.setDescription(newDescription);
			task.setUpdatedAt(LocalDateTime.now());
			saveTasks();
			System.out.println("Task updated successfully ☑️ (ID: " + id + ")");
		} else {
			System.out.println("Task not found 🤷 (ID: " + id + ")");
		}

	}

	/* Delete a task by id */
	public void deleteTask(int id) {
		Task task = findTaskById(id);

		if (task != null) {
			tasks.remove(task);
			saveTasks();
			System.out.println("Task deleted successfully ❌ (ID: " + id + ")");
		} else {
			System.out.println("Task not found 🤷 (ID: " + id + ")");
		}

	}

	/* Mark a task as in progress */
	public void markInProgress(int id) {
		updateTaskStatus(id, Status.IN_PROGRESS);
	}

	/* Mark a task as done */
	public void markDone(int id) {
		updateTaskStatus(id, Status.DONE);
	}

	/* List all tasks */
	public void listTasks() {
		tasks.forEach(task -> System.out.println(Mapper.toJson(task)));
	}

	/* List tasks by status */
	public void listTasksByStatus(Status status) {
		tasks.stream()
				.filter(task -> task.getStatus() == status)
				.forEach(task -> System.out.println(Mapper.toJson(task)));
	}

	private Task findTaskById(int id) {
		return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
	}

	private void updateTaskStatus(int id, Status status) {
		Task task = findTaskById(id);

		if (task != null) {
			task.setStatus(status);
			task.setUpdatedAt(LocalDateTime.now());
			saveTasks();
			System.out.println("Task status updated to " + status.toString().toLowerCase().replace("_", "-")
					+ " 🗽 (ID: " + id + ")");
		} else {
			System.out.println("Task not found 🤷 (ID: " + id + ")");
		}

	}

}
