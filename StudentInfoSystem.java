
import java.util.HashMap;
import java.util.Scanner;

class Student {
    
    HashMap<String, Integer> marks = new HashMap<>();
    int maxmarks = 0;
    int totalmarks = 0;
    int pass = 0;
    int fail = 0;
    String topper = "";
    
    void addStudent(String name, int m) {
        marks.put(name, m);
    }
    
    String getGrade(int m) {
        if (m >= 90) return "A";
        if (m >= 80) return "B";
        if (m >= 70) return "C";
        if (m >= 60) return "D";
        return "F";
    }
    
    void showStudents() {
        System.out.println("Name\tMarks\tGrade");
        for (String name : marks.keySet()) {
            int m = marks.get(name);
            String grade = getGrade(m);
            System.out.println(name + "\t" + m + "\t" + grade);
            
            if (m > maxmarks) {
                maxmarks = m;
                topper = name;
            }
            
            totalmarks = totalmarks + m;
            
            if (m >= 40) {
                pass = pass + 1;
            } else {
                fail = fail + 1;
            }
        }
    }
}

public class StudentInfoSystem {

    public static void main(String args[]) {
        
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to Student Grade System");
        System.out.println("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter student name: ");
            String name = sc.nextLine();
            
            System.out.println("Enter marks: ");
            int m = sc.nextInt();
            sc.nextLine();
            
            s.addStudent(name, m);
        }
        
        System.out.println("\n------- REPORT -------");
        s.showStudents();
        
        int avg = s.totalmarks / n;
        
        System.out.println("\nMax marks: " + s.maxmarks);
        System.out.println("Average marks: " + avg);
        System.out.println("Passed: " + s.pass);
        System.out.println("Failed: " + s.fail);
        System.out.println("Topper: " + s.topper);
        
        sc.close();
    }
}