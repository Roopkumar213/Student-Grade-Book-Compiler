
import java.util.HashMap;
import java.util.Scanner;


class StudentRecord {
    int marks;
    String grade;

    public StudentRecord(int marks) {
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    private String calculateGrade(int marks) {
        if (marks >= 90) return "A";
        else if (marks >= 80) return "B";
        else if (marks >= 70) return "C";
        else if (marks >= 60) return "D";
        else return "F";
    }
}


class  Student {

    int maxmarks = 0;
    int avgmarks=0;
    int pass =0;
    int fail =0;
    HashMap<String , StudentRecord> studentInfo = new HashMap<>();

    public HashMap<String, StudentRecord> AddStu(String name, int marks) {
        studentInfo.put(name, new StudentRecord(marks));
        return studentInfo;
    }

     public void getStudentInfo(){
         for ( String key: studentInfo.keySet()) {

            if ( maxmarks < studentInfo.get(key).marks) {
                maxmarks = studentInfo.get(key).marks;
            }

            avgmarks += studentInfo.get(key).marks;
           
            if ( studentInfo.get(key).marks >= 40) {
                pass++;
            } else {
                fail++;
            }

          int value = studentInfo.get(key).marks;
          String grade = studentInfo.get(key).grade;
          System.out.println(key + "\t" + value + "\t" + grade);
         }
     }


}

public class StudentInfoSystem {

    public static void main (String args[]){

    

        Student student = new Student();

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Student Information System");

        System.out.println("Please enter the details of the student: ");

        System.out.println("Enter number of students: ");
        int n  = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

        System.out.println("Enter the name of the student: ");
        String name = sc.nextLine();
        System.out.println("Enter the marks of the student: ");
        int marks = sc.nextInt();
        sc.nextLine(); 
        student.AddStu(name, marks);
        }  

       
     System.out.println("-----------Student Report------- ");
     System.out.println("Name\tMarks\tGrade");
     student.getStudentInfo();

     System.out.println("The maximum marks scored by a student is: " +  student.maxmarks);
     System.out.println("The number of students who passed is: " +  student.pass);
        System.out.println("The number of students who failed is: " +  student.fail);
     System.out.println("The average marks scored by the students is: " +  (student.avgmarks/n));

     System.out.println("Topper name is:"+ student.studentInfo.entrySet().stream()
        .max((entry1, entry2) -> Integer.compare(entry1.getValue().marks, entry2.getValue().marks))
        .get()
        .getKey());
     System.out.println("Thank you for using the Student Information System!");

    sc.close();
        
    }
}