package bubbleSort;
import java.util.*;

class Student {
    int rollNo;
    String name;
    double marks;

    public Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Marks: " + marks;
    }
}

public class Gum {
    private List<Student> students = new ArrayList<>();

    public void addStudent(int rollNo, String name, double marks) {
        students.add(new Student(rollNo, name, marks));
    }

    public void displayTopPerformers() {
        students.sort((s1, s2) -> Double.compare(s2.marks, s1.marks));
        System.out.println("Top Performers:");
        for (int i = 0; i < Math.min(3, students.size()); i++) {
            System.out.println(students.get(i));
        }
    }

    public Student searchByRollNo(int rollNo) {
        for (Student s : students) {
            if (s.rollNo == rollNo) {
                return s;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gum sm = new Gum();
        
        sm.addStudent(101, "Alice", 89.5);
        sm.addStudent(102, "Bob", 76.0);
        sm.addStudent(103, "Charlie", 92.3);
        sm.addStudent(104, "David", 85.0);
        sm.addStudent(105, "Eve", 95.2);
        
        sm.displayTopPerformers();
        
        System.out.print("Enter Roll No to search: ");
        int rollNo = sc.nextInt();
        Student result = sm.searchByRollNo(rollNo);
        
        if (result != null) {
            System.out.println("Student Found: " + result);
        } else {
            System.out.println("Student not found.");
        }
    }
}
