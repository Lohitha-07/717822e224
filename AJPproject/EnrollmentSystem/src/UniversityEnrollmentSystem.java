
import java.sql.*;
import java.util.*;

public class UniversityEnrollmentSystem {
    private Connection connection;

    // Constructor to initialize database connection
    public UniversityEnrollmentSystem() {
        try {
            // Load MySQL JDBC driver and establish connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", username, password);
            if (connection != null) {
                System.out.println("Database connection established successfully.");
            } else {
                System.out.println("Failed to establish database connection.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a new student to the database
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

    // Method to add a new course to the database
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

    // Method to add a new faculty member to the database
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

    // Method to enroll a student in a course
    public void enrollStudentInCourse(int studentID, int courseID) {
        try {
            String query = "INSERT INTO enrollments (student_id, course_id, enrollment_date) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, studentID);
            statement.setInt(2, courseID);
            
            // Set enrollment date to current date
            java.sql.Date enrollmentDate = new java.sql.Date(System.currentTimeMillis());
            statement.setDate(3, enrollmentDate);
            
            statement.executeUpdate();
            System.out.println("Student enrolled in course successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Method to display all available courses
    public void displayAllCourses() {
        try {
            String query = "SELECT * FROM courses";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("\nAvailable Courses:");
            System.out.println("Course ID\tCourse Name\tCourse Description");

            // Print course details
            while (resultSet.next()) {
                int courseId = resultSet.getInt("course_id");
                String courseName = resultSet.getString("course_name");
                String courseDescription = resultSet.getString("course_description");

                System.out.println(courseId + "\t\t" + courseName + "\t\t" + courseDescription + "\t\t");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to assign a faculty member to a course
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

    // Method to close the database connection
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

    // Main method to run the application
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // Create an instance of the UniversityEnrollmentSystem class
        UniversityEnrollmentSystem enrollmentSystem = new UniversityEnrollmentSystem();
        Scanner scanner = new Scanner(System.in);

        // Display menu options and handle user input
        while (true) {
            System.out.println("\nUniversity Enrollment System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Add Faculty");
            System.out.println("4. Enroll Student in Course");
            System.out.println("5. Assign Faculty to Course");
            System.out.println("6. Display All Courses");
            System.out.println("7. Exit");

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
                    System.out.print("Enter course name: ");
                    String courseName = scanner.next();
                    System.out.print("Enter course description: ");
                    String courseDescription = scanner.next();
                    enrollmentSystem.addCourse(courseName, courseDescription);
                    break;
                case 3:
                    System.out.print("Enter faculty name: ");
                    String facultyName = scanner.next();
                    System.out.print("Enter faculty email: ");
                    String facultyEmail = scanner.next();
                    enrollmentSystem.addFaculty(facultyName, facultyEmail);
                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    int studentID = scanner.nextInt();
                    System.out.print("Enter course ID: ");
                    int courseID = scanner.nextInt();
                    enrollmentSystem.enrollStudentInCourse(studentID, courseID);
                    break;
                case 5:
                    System.out.print("Enter faculty ID: ");
                    int facultyID = scanner.nextInt();
                    System.out.print("Enter course ID: ");
                    int courseIDForFaculty = scanner.nextInt();
                    enrollmentSystem.assignFacultyToCourse(facultyID, courseIDForFaculty);
                    break;
                case 6:
                    enrollmentSystem.displayAllCourses();
                    break;
                case 7:
                    enrollmentSystem.closeConnection();
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
