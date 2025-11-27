package congress;
import java.util.ArrayList; 
import java.util.List; 

public class Student {  
    private int id;  
    private String firstName;  
    private String lastName;
    private String academicLevel;
    private String subject;
    private List<Integer> grades;  
    
    public Student(int id, String firstName, String lastName, String academicLevel , String subject) {  
        this.id = id;  
        this.firstName = firstName;  
        this.lastName = lastName;
        this.academicLevel = academicLevel;
        this.subject = subject;
        this.grades = new ArrayList<>();  
    }  
    public int getId() 
    { 
    	return id; 
    }  
    public String getFirstName() 
    { 
    	return firstName; 
    }  
    public void setFirstName(String firstName) 
    { 
    	this.firstName = firstName; 
    }  
    public String getLasttName() 
    { 
    	return lastName; 
    }  
    public void setLastName(String lastName) 
    { 
    	this.lastName = lastName; 
    }  
    
    public String getAcademicLevel() 
    { 
    	return academicLevel; 
    }  
    public void setAcademicLevel(String academicLevel) 
    { 
    	this.academicLevel = academicLevel; 
    }  
    
    
    public String getSubject() 
    { 
    	return subject; 
    }  
    public void setSubject(String subject) 
    { 
    	this.subject = subject; 
    }  
    public void addGrade(int grade) 
    {  
        grades.add(grade);  
    }  
    public List<Integer> getGrades() 
    { 
    	return grades; 
    }  
    public double getAverageGrade() 
    {  
        if (grades.isEmpty()) 
        	return 0.0;  
        int sum = 0;  
        for (int g : grades) 
        {  
            sum += g;  
        }  
        return (double) sum / grades.size();  
    }  
  
    
    public String getLetterGrade() {
        double avg = getAverageGrade();
        if (avg >= 90) {
            return "A";
        } else if (avg >= 80) {
            return "B";
        } else if (avg >= 70) {
            return "C";
        } else if (avg >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    public String toString() 
    {  
        return "Student Id: " + id + ", First Name: " + firstName + ", Last Name: " + lastName +  ", Academic Level: " + academicLevel    +  ", Subject: " + subject + ", Grades: " + grades + ", Average Grade: " + String.format("%.2f", getAverageGrade() )+ ", Letter Grade: " +getLetterGrade();  
    }  
}  