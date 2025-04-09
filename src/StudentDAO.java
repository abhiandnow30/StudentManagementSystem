import java.sql.*;
import java.util.*;

    public class StudentDAO {

        public void addStudent(Student student) {
            String sql = "INSERT INTO students (name, roll_no, course, email) VALUES (?, ?, ?, ?)";
            
            try (Connection conn = DataBaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, student.getName());
                pstmt.setString(2, student.getRollNo());
                pstmt.setString(3, student.getCourse());
                pstmt.setString(4, student.getEmail());
                pstmt.executeUpdate();
                System.out.println("Student added successfully.");
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        public void updateStudent(Student student) {
            String sql = "UPDATE students SET name = ?, roll_no = ?, course = ?, email = ? WHERE id = ?";
            try (Connection conn = DataBaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, student.getName());
                pstmt.setString(2, student.getRollNo());
                pstmt.setString(3, student.getCourse());
                pstmt.setString(4, student.getEmail());
                pstmt.setInt(5, student.getId());

                int rows = pstmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("Student updated successfully.");
                } else {
                    System.out.println("Student not found.");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        public void deleteStudent(int id) {
            String sql = "DELETE FROM students WHERE id = ?";
            try (Connection conn = DataBaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, id);
                int rows = pstmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("Student deleted successfully.");
                } else {
                    System.out.println("Student not found.");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        public Student getStudentByRollNo(String rollNo) {
            String sql = "SELECT * FROM students WHERE roll_no = ?";
            try (Connection conn = DataBaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, rollNo);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    return new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("roll_no"),
                            rs.getString("course"),
                            rs.getString("email")
                    );
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
            return null;
        }




        public List<Student> getAllStudents() {
            List<Student> students = new ArrayList<>();
            String sql = "SELECT * FROM students";
            try (Connection conn = DataBaseConnection.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    Student s = new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("roll_no"),
                            rs.getString("course"),
                            rs.getString("email")
                    );
                    students.add(s);
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
            return students;
        }

        // Add update and delete methods as well
    }


