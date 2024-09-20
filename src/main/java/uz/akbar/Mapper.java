package uz.akbar;

import java.time.LocalDateTime;

/**
 * Mapper
 */
public class Mapper {

	public static String toJson(Task task) {
		StringBuilder sb = new StringBuilder();

		sb.append("{")
				.append("\"id\": ").append(task.getId()).append(", ")
				.append("\"description\": \"").append(task.getDescription()).append("\", ")
				.append("\"status\": \"").append(task.getStatus()).append("\", ")
				.append("\"createdAt\": \"").append(task.getCreatedAt()).append("\", ")
				.append("\"updatedAt\": \"").append(task.getUpdatedAt()).append("\"")
				.append("}");
		return sb.toString();
	}

	public static Task fromJson(String json) {
		String[] parts = json.replace("{", "").replace("}", "").split(", ");

		int id = Integer.parseInt(parts[0].split(": ")[1]);
		String description = parts[1].split(": ")[1];
		String statusStr = parts[2].split(": ")[1].replace("\"", "");
		Status status = Status.valueOf(statusStr);
		String createdAt = parts[3].split(": ")[1].replace("\"", "");
		String updatedAt = parts[4].split(": ")[1].replace("\"", "");

		return new Task(id, description, status, LocalDateTime.parse(createdAt), LocalDateTime.parse(updatedAt));
	}

}
