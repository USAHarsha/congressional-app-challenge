package congress;
import java.util.ArrayList;  
import java.util.List;  
import java.util.Scanner; 

public class StudentProgressTracker {  
    private List<Student> students = new ArrayList<>();  
    private Scanner keyboard = new Scanner(System.in);  
    
    public static void main(String[] args) {  
        StudentProgressTracker tracker = new StudentProgressTracker();  
        tracker.displayMenu();  
    }  
    
    //Add a new student
    public void addStudent() {  
        System.out.print("Enter Student ID: ");  
        int id = Integer.parseInt(keyboard.nextLine());  
        System.out.print("Enter Student First Name: ");  
        String firstName = keyboard.nextLine(); 
        System.out.print("Enter Student Last Name: ");  
        String lastName = keyboard.nextLine(); 
        System.out.print("Enter Student Academic Level: ");  
        String academicLevel = keyboard.nextLine(); 
        System.out.print("Enter Student Subject: ");  
        String subject = keyboard.nextLine(); 
        if (searchStudentById(id) != null) {  
            System.out.println("Student ID already exists!");  
            return;  
        }  
        students.add(new Student(id, firstName, lastName,academicLevel,subject));  
        System.out.println("Student added successfully.");  
    }  
    
    //Update existing student
    public void updateStudent() {  
    	System.out.print("Enter Student ID to update: ");  
        int id = Integer.parseInt(keyboard.nextLine());  
        Student student = searchStudentById(id);  
        if (student == null) {  
            System.out.println("No students found.");  
            return;  
        }  
        System.out.print("Enter new First Name: ");  
        String newFirstName = keyboard.nextLine();  
        student.setFirstName(newFirstName);
        System.out.print("Enter new Last Name: ");  
        String newLastName = keyboard.nextLine();  
        student.setLastName(newLastName); 
       
        System.out.print("Enter new Academic Level: ");  
        String newAcademicLevel = keyboard.nextLine();  
        student.setAcademicLevel(newAcademicLevel);
        
        System.out.println("Student name updated.");  
    } 
    
    // Display all students
    public void viewAllStudents() {  
        if (students.isEmpty()) {  
            System.out.println("No students registered.");  
            return;  
        }  
        System.out.println("Student List and Progress:");  
        for (Student st : students) {  
            System.out.println(st);  
        }  
    }  
    // Remove a student
    public void deleteStudent() {  
        System.out.print("Enter Student ID to delete: ");  
        int id = Integer.parseInt(keyboard.nextLine());  
        Student student = searchStudentById(id);  
        if (student == null) {  
            System.out.println("Student not found.");  
            return;  
        }  
        students.remove(student);  
        System.out.println("Student deleted.");  
    }  
    
    // Add grade to a student  
    public void addGradeToStudent() {  
        System.out.print("Enter Student ID to add score to: ");  
        int id = Integer.parseInt(keyboard.nextLine());  
        Student student = searchStudentById(id);  
        if (student == null) {  
            System.out.println("Student not found.");  
            return;  
        }  
        System.out.print("Enter student score (0-100): ");  
        int grade = Integer.parseInt(keyboard.nextLine());  
        if (grade < 0 || grade > 100) {  
            System.out.println("Invalid grade.");  
            return;  
        }  
        student.addGrade(grade);  
        System.out.println("Grade added.");  
    }  
  
    // Search student by ID  
    public Student searchStudentById(int id) {  
        for (Student s : students) {  
            if (s.getId() == id) {  
                return s;  
            }  
        }  
        return null;  
    }  
   
    // Display menu options
    public void displayMenu() {  
        while (true) {  
            System.out.println("Student Progress Tracker");  
            System.out.println("1. Add Student");  
            System.out.println("2. Update a Student");  
            System.out.println("3. Delete a Student");  
            System.out.println("4. Display All Students"); 
            System.out.println("5. Add Score to a Student");  
            System.out.println("6. Exit the App");  
            System.out.print("Choose an option: ");  
            String choice = keyboard.nextLine();  
            
            switch (choice) {  
                case "1": 
                	addStudent(); 
                	break;  
                case "2": 
                	updateStudent(); 
                	break;  
                case "3": 
                	deleteStudent(); 
                	break;  
                case "4": 
                	viewAllStudents(); 
                	break;  
                case "5": 
                	addGradeToStudent(); 
                	break;  
                case "6": 
                	System.out.println("Exiting the App, Bye!"); 
                	return;  
                default: 
                	System.out.println("Invalid menu choice.");  
            }  
        }  
    } 
    
   
}