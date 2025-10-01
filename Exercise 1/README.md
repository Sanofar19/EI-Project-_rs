 Astronaut Daily Schedule Organizer

 Project Overview
This console-based Java application helps astronauts efficiently manage their daily tasks during space missions.  
It focuses on robust **task scheduling, conflict management, and priority handling**, demonstrating advanced **OOP principles** and **design patterns**.

 Use Cases

1. **Add Task**  
   Allows astronauts to add a new task with description, start time, end time, and priority. Ensures no overlap with existing tasks.

2. **Remove Task**  
   Removes an existing task from the schedule, with proper validation for non-existent tasks.

3. **View Tasks**  
   Lists all scheduled tasks sorted by start time for easy daily planning.

4. **Conflict Notification**  
   Notifies astronauts if a new task conflicts with existing tasks using the **Observer Pattern**.

5. **Task Factory Creation**  
   Creates task objects using the **Factory Pattern**, ensuring consistent task initialization.

6. **Schedule Management Singleton**  
   Manages all tasks centrally with **Singleton Pattern**, preventing multiple instances of the schedule manager.

## Design Patterns Implemented
- **Singleton** – `ScheduleManager`  
- **Factory** – `TaskFactory`  
- **Observer** – Conflict notifications  

## Key Features
- Task CRUD operations (Create, Read, Update, Delete)  
- Priority-based scheduling  
- Input validations and exception handling  
- Optimized for performance in long-running usage  

