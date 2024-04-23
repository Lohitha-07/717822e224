package project;

import java.sql.*;
import java.util.*;

public class UniversityEnrollmentSystem {
    private Connection connection;

    public UniversityEnrollmentSystem() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name", username, password);
            if (connection != null) {
                System.out.println("Database connection established successfully.");
            } else {
                System.out.println("Failed to establish database connection.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(String name, String email) {
        try {
            String query = "INSERT INTO students (name, email) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateStudent(int studentID, String newName, String newEmail) {
        try {
            String query = "UPDATE students SET name = ?, email = ? WHERE student_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newName);
            statement.setString(2, newEmail);
            statement.setInt(3, studentID);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("No student found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteStudent(int studentID) {
        try {
            String query = "DELETE FROM students WHERE student_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, studentID);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("No student found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayAllStudents() {
        try {
            String query = "SELECT * FROM students";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("\nAll Students:");
            System.out.println("Student ID\tName\tEmail");

            while (resultSet.next()) {
                int studentId = resultSet.getInt("student_id");
                String studentName = resultSet.getString("name");
                String studentEmail = resultSet.getString("email");

                System.out.println(studentId + "\t\t" + studentName + "\t" + studentEmail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addFaculty(String name, String email) {
        try {
            String query = "INSERT INTO faculty (name, email) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.executeUpdate();
            System.out.println("Faculty added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateFaculty(int facultyID, String newName, String newEmail) {
        try {
            String query = "UPDATE faculty SET name = ?, email = ? WHERE faculty_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newName);
            statement.setString(2, newEmail);
            statement.setInt(3, facultyID);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Faculty updated successfully.");
            } else {
                System.out.println("No faculty found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteFaculty(int facultyID) {
        try {
            String query = "DELETE FROM faculty WHERE faculty_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, facultyID);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Faculty deleted successfully.");
            } else {
                System.out.println("No faculty found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayAllFaculty() {
        try {
            String query = "SELECT * FROM faculty";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("\nAll Faculty:");
            System.out.println("Faculty ID\tName\tEmail");

            while (resultSet.next()) {
                int facultyId = resultSet.getInt("faculty_id");
                String facultyName = resultSet.getString("name");
                String facultyEmail = resultSet.getString("email");

                System.out.println(facultyId + "\t\t" + facultyName + "\t" + facultyEmail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addCourse(String courseName, String courseDescription) {
        try {
            String query = "INSERT INTO courses (course_name, course_description) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, courseName);
            statement.setString(2, courseDescription);
            statement.executeUpdate();
            System.out.println("Course added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateCourse(int courseID, String newCourseName, String newCourseDescription) {
        try {
            String query = "UPDATE courses SET course_name = ?, course_description = ? WHERE course_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newCourseName);
            statement.setString(2, newCourseDescription);
            statement.setInt(3, courseID);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Course updated successfully.");
            } else {
                System.out.println("No course found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteCourse(int courseID) {
        try {
            String query = "DELETE FROM courses WHERE course_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, courseID);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Course deleted successfully.");
            } else {
                System.out.println("No course found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayAllCourses() {
        try {
            String query = "SELECT c.course_id, c.course_name, c.course_description, f.name AS faculty_name " +
                           "FROM courses c LEFT JOIN faculty f ON c.faculty_id = f.faculty_id";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("\nAll Courses:");
            System.out.println("Course ID\tCourse Name\tCourse Description\tFaculty Name");

            while (resultSet.next()) {
                int courseId = resultSet.getInt("course_id");
                String courseName = resultSet.getString("course_name");
                String courseDescription = resultSet.getString("course_description");
                String facultyName = resultSet.getString("faculty_name");

                System.out.println(courseId + "\t\t" + courseName + "\t\t" + courseDescription + "\t\t\t" + facultyName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void assignFacultyToCourse(int facultyID, int courseID) {
        try {
            String query = "UPDATE courses SET faculty_id = ? WHERE course_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, facultyID);
            statement.setInt(2, courseID);
            statement.executeUpdate();
            System.out.println("Faculty assigned to course successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        UniversityEnrollmentSystem enrollmentSystem = new UniversityEnrollmentSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nUniversity Enrollment System Menu:");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Faculty");
            System.out.println("3. Manage Courses");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    studentManagementMenu(enrollmentSystem, scanner);
                    break;
                case 2:
                    facultyManagementMenu(enrollmentSystem, scanner);
                    break;
                case 3:
                    courseManagementMenu(enrollmentSystem, scanner);
                    break;
                case 4:
                    enrollmentSystem.closeConnection();
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    public static void studentManagementMenu(UniversityEnrollmentSystem enrollmentSystem, Scanner scanner) {
        while (true) {
            System.out.println("\nManage Students:");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Back to Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.next();
                    System.out.print("Enter student email: ");
                    String studentEmail = scanner.next();
                    enrollmentSystem.addStudent(studentName, studentEmail);
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    int studentID = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.next();
                    enrollmentSystem.updateStudent(studentID, newName, newEmail);
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    int deleteStudentID = scanner.nextInt();
                    enrollmentSystem.deleteStudent(deleteStudentID);
                    break;
                case 4:
                    enrollmentSystem.displayAllStudents();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    public static void facultyManagementMenu(UniversityEnrollmentSystem enrollmentSystem, Scanner scanner) {
        while (true) {
            System.out.println("\nManage Faculty:");
            System.out.println("1. Add Faculty");
            System.out.println("2. Update Faculty");
            System.out.println("3. Delete Faculty");
            System.out.println("4. Assign Course to Faculty");
            System.out.println("5. Display All Faculty");
            System.out.println("6. Back to Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter faculty name: ");
                    String facultyName = scanner.next();
                    System.out.print("Enter faculty email: ");
                    String facultyEmail = scanner.next();
                    enrollmentSystem.addFaculty(facultyName, facultyEmail);
                    break;
                case 2:
                    System.out.print("Enter faculty ID: ");
                    int facultyID = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String newFacultyName = scanner.next();
                    System.out.print("Enter new email: ");
                    String newFacultyEmail = scanner.next();
                    enrollmentSystem.updateFaculty(facultyID, newFacultyName, newFacultyEmail);
                    break;
                case 3:
                    System.out.print("Enter faculty ID: ");
                    int deleteFacultyID = scanner.nextInt();
                    enrollmentSystem.deleteFaculty(deleteFacultyID);
                    break;
                case 4:
                    System.out.print("Enter faculty ID: ");
                    int facultyIDForCourse = scanner.nextInt();
                    System.out.print("Enter course ID: ");
                    int courseIDForFaculty = scanner.nextInt();
                    enrollmentSystem.assignFacultyToCourse(facultyIDForCourse, courseIDForFaculty);
                    break;
                case 5:
                    enrollmentSystem.displayAllFaculty();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    public static void courseManagementMenu(UniversityEnrollmentSystem enrollmentSystem, Scanner scanner) {
        while (true) {
            System.out.println("\nManage Courses:");
            System.out.println("1. Add Course");
            System.out.println("2. Update Course");
            System.out.println("3. Delete Course");
            System.out.println("4. Display All Courses");
            System.out.println("5. Back to Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter course name: ");
                    String courseName = scanner.next();
                    System.out.print("Enter course description: ");
                    String courseDescription = scanner.next();
                    enrollmentSystem.addCourse(courseName, courseDescription);
                    break;
                case 2:
                    System.out.print("Enter course ID: ");
                    int courseID = scanner.nextInt();
                    System.out.print("Enter new course name: ");
                    String newCourseName = scanner.next();
                    System.out.print("Enter new course description: ");
                    String newCourseDescription = scanner.next();
                    enrollmentSystem.updateCourse(courseID, newCourseName, newCourseDescription);
                    break;
                case 3:
                    System.out.print("Enter course ID: ");
                    int deleteCourseID = scanner.nextInt();
                    enrollmentSystem.deleteCourse(deleteCourseID);
                    break;
                case 4:
                    enrollmentSystem.displayAllCourses();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
