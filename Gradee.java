import java.util.*;
 abstract class StudentName{
     String name;
    public StudentName(String a){
         this.name = a;
         
     }
     abstract void DisplayResult();
 }
 class Student extends StudentName{
    int marks[];
      int total;
    double average;
    double attendance;
    boolean isAssignmentCompleted;

    public Student(String name , double attendance, boolean isAssignmentCompleted) {
        super(name);
        this.attendance = attendance;
        this.isAssignmentCompleted = isAssignmentCompleted;
    
}
 public void Calculate(Scanner sc){

marks = new int[5];
    total = 0;
    for (int i = 0; i < 5; i++) {
        System.out.print("Enter marks for Subject " + (i + 1) + ": ");
        marks[i] = sc.nextInt();
        total += marks[i];
    }
    average = total / 5.0;
}

    public String getGrade() {
        if (average >= 90 && attendance >= 85 && isAssignmentCompleted) {
            return "A";
        } else if (average >= 75 && attendance >= 75) {
            return "B";
        } else if (average  >= 60) {
            return "C";
        } else {
            return "D";
        }
    }
    public String Remark() {
    switch(getGrade()){
            case "A":
           return "Excellent , Keep it up";
           case "B":
           return "very Good";
           case "C":
           return "Good Job";
            default:
            return "Needs improvement";
     }
   }
 
      public void DisplayResult() {
        System.out.println("Student: " + name);
          System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + getGrade());
        System.out.println("Remark: " + Remark());


    }


}
public class Gradee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students:");
        int n = sc.nextInt();
        sc.nextLine();

        List<Student> students = new ArrayList<>();
        for (int i=0;i<n;i++){   
        System.out.println("\nStudent #" + (i + 1));

        System.out.println("Enter Student Name:");
        String name = sc.nextLine();

        System.out.println("Enter your Attendance:");
        double attendance = sc.nextDouble();
        sc.nextLine();

        System.out.println("Is your Assignment Completed? (yes/no):");
        String input = sc.nextLine();
        boolean isAssignmentCompleted = input.equalsIgnoreCase("yes");
        Student object = new Student(name ,attendance, isAssignmentCompleted);
           students.add(object);
           object.Calculate(sc);
        }
         System.out.println("Student Result:");
          System.out.println();
        for (Student s : students) {
            s.DisplayResult();
            System.out.println();
        }
        
         
    }
}
 


