import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll No");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter roll no: ");
                    String rollNo = sc.nextLine();
                    System.out.print("Enter course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    Student newStudent = new Student(0, name, rollNo, course, email);
                    dao.addStudent(newStudent);
                    break;

                case 2:
                    List<Student> students = dao.getAllStudents();
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    String searchRoll = sc.nextLine();
                    Student found = dao.getStudentByRollNo(searchRoll);
                    if (found != null) {
                        System.out.println("Student found: " + found);
                    } else {
                        System.out.println("No student found with roll number " + searchRoll);
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID to update: ");
                    int idToUpdate = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter new name: ");
                    String updName = sc.nextLine();
                    System.out.print("Enter new roll no: ");
                    String updRoll = sc.nextLine();
                    System.out.print("Enter new course: ");
                    String updCourse = sc.nextLine();
                    System.out.print("Enter new email: ");
                    String updEmail = sc.nextLine();

                    Student updatedStudent = new Student(idToUpdate, updName, updRoll, updCourse, updEmail);
                    dao.updateStudent(updatedStudent);
                    break;

                case 5:
                    System.out.print("Enter student ID to delete: ");
                    int idToDelete = sc.nextInt();
                    dao.deleteStudent(idToDelete);
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
