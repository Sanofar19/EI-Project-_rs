 Virtual Classroom Manager

 Project Overview
A terminal-based Java application to manage virtual classrooms for an EdTech platform.  
This project models **relationships between classrooms, students, and assignments**, demonstrating **design patterns, SOLID principles, and error handling** in a real-world education context.

 Use Cases

1. **Add Classroom**  
   Creates a new virtual classroom for online sessions.

2. **Enroll Student**  
   Adds a student to a specific classroom and tracks enrollment.

3. **Schedule Assignment**  
   Creates assignments for a classroom and stores them for student submissions.

4. **Submit Assignment**  
   Marks a student’s assignment as submitted and notifies observers.

5. **Submission Notification**  
   Uses the **Observer Pattern** to notify when an assignment is submitted.

6. **Centralized Classroom Management**  
   **Singleton Pattern** ensures all classrooms are managed through a single instance of `ClassroomManager`.

 Design Patterns Implemented
- **Singleton** – `ClassroomManager`  
- **Factory** – `ClassroomFactory`, `StudentFactory`, `AssignmentFactory`  
- **Observer** – `SubmissionNotifier` for assignment submissions  

 Key Features
- Classroom, student, and assignment management  
- Console-based, lightweight application  
- Input validation and exception handling  
- Modular, maintainable OOP code  


