
# University Enrollment System

The University Enrollment System is a Java console application designed to manage student enrollments, courses, and faculty assignments within a university setting. It provides functionalities to add students, courses, and faculty members to a database, enroll students in courses, assign faculty to courses, and display available courses.

# Setup Instructions

## Prerequisites
  • Java Development Kit (JDK) installed on your system.
  
  • MySQL database server installed on your system.

 ## Database 
  1. Start your MySQL database server.
  2. Create a new database named project.
  3. Create the following tables within the project database:
     
      • students: Columns - student_id (INT, AUTO_INCREMENT), name (VARCHAR), email (VARCHAR)
        
      • courses: Columns - course_id (INT, AUTO_INCREMENT), course_name (VARCHAR), course_description (VARCHAR), faculty_id (INT)
        
      • faculty: Columns - faculty_id (INT, AUTO_INCREMENT), name (VARCHAR), email (VARCHAR)
        
      •  enrollments: Columns - enrollment_id (INT, AUTO_INCREMENT), student_id (INT), course_id (INT), enrollment_date (DATE)
      
  4. Ensure your MySQL server is running on localhost with the default port 3306, and the username and password are set to the server which has the database.
     
## Application Setup
  1. Clone this repository to your local machine.
  2. Navigate to the project directory in your terminal or command prompt.
    
# User Guide

## Running the Application
  1. Compile the Java source files using the following command:
```bash
   javac UniversityEnrollmentSystem.java
   ```
  2. Run the compiled Java application using the following command:
```bash
   java UniversityEnrollmentSystem.java
   ```
    
# Using the Application
 1. Upon running the application, you will be presented with a menu displaying various options.
  2. Choose an option by entering the corresponding number and pressing Enter.
  3. Follow the prompts to input data as required for each option.
  4. Use the menu option 7 to exit the application.

## Menu Options
### Main Menu:
Upon running the application, you will see the main menu with the following options:
  1. Manage Students: Allows you to perform operations related to students (add, update, delete, display).
  2. Manage Faculty: Allows you to perform operations related to faculty members (add, update, delete, display, assign course).
  3. Manage Courses: Allows you to perform operations related to courses (add, update, delete, display).
  4. Exit: Exits the application.

### Manage Students:
  1. Add Student: Adds a new student to the database. You'll be prompted to enter the student's name and email.
  2. Update Student: Updates an existing student's information. You'll be prompted to enter the student's ID, new name, and new email.
  3. Delete Student: Deletes a student from the database. You'll be prompted to enter the student's ID.
  4. Display All Students: Displays a list of all students currently stored in the database.

### Manage Faculty:
  1. Add Faculty: Adds a new faculty member to the database. You'll be prompted to enter the faculty member's name and email.
  2. Update Faculty: Updates an existing faculty member's information. You'll be prompted to enter the faculty member's ID, new name, and new email.
  3. Delete Faculty: Deletes a faculty member from the database. You'll be prompted to enter the faculty member's ID.
  4. Assign Course to Faculty: Assigns a course to a faculty member. You'll be prompted to enter the faculty member's ID and the course ID.
  5. Display All Faculty: Displays a list of all faculty members currently stored in the database.
 
### Manage Courses:
1. Add Course: Adds a new course to the database. You'll be prompted to enter the course name and description.
2. Update Course: Updates an existing course's information. You'll be prompted to enter the course ID, new name, and new description.
3. Delete Course: Deletes a course from the database. You'll be prompted to enter the course ID.
4. Display All Courses: Displays a list of all courses currently stored in the database.
