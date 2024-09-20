package uz.akbar;

import java.time.LocalDateTime;

/**
 * Task
 */
public class Task {

	private int id;

	private String description;

	private Status status = Status.TODO;

	private LocalDateTime createdAt = LocalDateTime.now();

	private LocalDateTime updatedAt = LocalDateTime.now();

	public Task() {
	}

	public Task(int id, String description) {
		this.id = id;
		this.description = description;
		this.status = Status.TODO;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}

	public Task(int id, String description, Status status, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Task {" + "\n\t" +
				"id= " + id + "\n\t" +
				"description= " + description + "\n\t" +
				"status= " + status + "\n\t" +
				"createdAt= " + createdAt + "\n\t" +
				"updatedAt= " + updatedAt + "\n" +
				"}";
	}

}
