# Task Tracker CLI

## Description
Task Tracker CLI is a command-line application built using Java ☕️ (Maven 🪶), not using any external libraries 📚.
It helps users manage their tasks ✅ list by providing options to add ☑️, update ✏️, delete ❌, and list tasks 🫣.
Tasks are stored in a JSON file 📄 for persistence.

## Features
```bash
# Adding a new task 
task-cli add "Buy groceries"
# Output: Task added successfully (ID: 1)

# Updating and deleting tasks
task-cli update 1 "Buy groceries and cook dinner"
task-cli delete 1

# Marking a task as in progress or done
task-cli mark-in-progress 1
task-cli mark-done 1

# Listing all tasks
task-cli list

# Listing tasks by status
task-cli list done
task-cli list todo
task-cli list in-progress
```
## Usage
First, clone the repository and navigate to the project directory:
```bash
git clone https://github.com/MuhammadAkbar007/task-tracker-cli.git
cd task-tracker-cli
```
Compile and package the project
```bash
mvn clean package
```
Run the Task Tracker
```bash
java -jar target/task-tracker-cli.jar [COMMAND]
```
## Project structure
* `src/main/java/`: Contains the main application source code.
* `data/`: Contains the JSON file used to store tasks.
* `target/`: Contains the compiled output and the JAR file.

## Project idea
The idea is taken from [Roadmap](https://roadmap.sh/) projects for beginners [task](https://roadmap.sh/projects/task-tracker)

## Author
Created by [Akbar](https://github.com/MuhammadAkbar007).
