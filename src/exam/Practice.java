// Create a system to manage student data using java collection framework. 
// The program should be:
//	1. Store student details such as roll_no, name, marks, using an arraylist.
//	2. Sort students based on marks in descending order, and display the top three performers.
//	3. Allow searching for a student by roll number.

package exam;
import java.util.*;

class Student {
    int rollNo;
    String name;
    int marks;

    public Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
    
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Marks: " + marks;
    }
}

public class Practice {
    public List<Student> students = new ArrayList<>();

    public void addStudent(int rollNo, String name, int marks) {
        students.add(new Student(rollNo, name, marks));
    }
    
    public void displayAllStudents() {
        System.out.println("All Students:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }
    
    public void displayTopPerformers() {
        students.sort((s1, s2) -> Integer.compare(s2.marks, s1.marks));
        System.out.println("Top 3 Performers:");
        for (int i = 0; i < Math.min(3, students.size()); i++) {
            System.out.println(students.get(i));
        }
    }
    
    public void searchStudentByRollNo(int rollNo) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).rollNo == rollNo) {
                System.out.println("Student Found: " + students.get(i));
                return;
            }
        }
        System.out.println("Student with Roll No " + rollNo + " not found.");
    }
    
    public static void main(String[] args) {
        Practice obj = new Practice();
        Scanner scanner = new Scanner(System.in);
        
        obj.addStudent(1, "Vedant", 56);
        obj.addStudent(2, "Nikhil", 76);
        obj.addStudent(3, "Saurav", 92);
        obj.addStudent(4, "Suresh", 85);
        obj.addStudent(5, "Rajesh", 43);
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Display All Students");
            System.out.println("2. Display Top 3 Students");
            System.out.println("3. Search Student by Roll No");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    obj.displayAllStudents();
                    break;
                case 2:
                    obj.displayTopPerformers();
                    break;
                case 3:
                    System.out.print("Enter roll number to search: ");
                    int rollNo = scanner.nextInt();
                    obj.searchStudentByRollNo(rollNo);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
