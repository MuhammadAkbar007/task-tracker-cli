package uz.akbar;

/**
 * Main
 */
public class Main {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Please provide a command. 💬");
			return;
		}

		String command = args[0];
		TaskManager taskManager = null;

		try {
			taskManager = new TaskManager();

			switch (command) {
				case "add":
					if (args.length >= 2) {
						taskManager.addTask(args[1]);
					} else {
						System.out.println("Please provide task description! 📔");
					}
					break;

				case "update":
					if (args.length >= 3) {
						taskManager.updateTask(Integer.parseInt(args[1]), args[2]);
					} else {
						System.out.println("Please provide ID and new description! 📔");
					}
					break;

				case "delete":
					if (args.length >= 2) {
						taskManager.deleteTask(Integer.parseInt(args[1]));
					} else {
						System.out.println("Please provide ID! 🆔");
					}
					break;

				case "mark-in-progress":
					if (args.length >= 2) {
						taskManager.markInProgress(Integer.parseInt(args[1]));
					} else {
						System.out.println("Please provide ID! 🆔");
					}
					break;

				case "mark-done":
					if (args.length >= 2) {
						taskManager.markDone(Integer.parseInt(args[1]));
					} else {
						System.out.println("Please provide ID! 🆔");
					}
					break;

				case "list":
					if (args.length >= 2) {
						String input = args[1].toUpperCase();

						try {
							Status status = Status.valueOf(input);
							taskManager.listTasksByStatus(status);
						} catch (Exception e) {
							System.out.println("Unknown status: " + input + "🗽");
						}

					} else {
						taskManager.listTasks();
					}
					break;

				default:
					System.out.println("Unknown command: " + command + " 🤷");
					break;
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
