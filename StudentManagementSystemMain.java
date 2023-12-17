package codSoftInternship;

	import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

	class Student implements Serializable {
	    private String name;
	    private int rollNumber;
	    private String grade;

	    // Constructor
	    public Student(String name, int rollNumber, String grade) {
	        this.name = name;
	        this.rollNumber = rollNumber;
	        this.grade = grade;
	    }

	    // Getters and setters
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getRollNumber() {
	        return rollNumber;
	    }

	    public void setRollNumber(int rollNumber) {
	        this.rollNumber = rollNumber;
	    }

	    public String getGrade() {
	        return grade;
	    }

	    public void setGrade(String grade) {
	        this.grade = grade;
	    }

	    // toString method to display student information
	    @Override
	    public String toString() {
	        return "Student{" +
	                "name='" + name + '\'' +
	                ", rollNumber=" + rollNumber +
	                ", grade='" + grade + '\'' +
	                '}';
	    }
	}

	class StudentManagementSystem {
	    private ArrayList<Student> studentList;
		private String filePath;

	    public StudentManagementSystem(String filePath) {
	    	this.filePath = filePath;
	        this.studentList = new ArrayList<>();
	    }

	    public void addStudent(Student student) {
	        studentList.add(student);
	    }

	    public int removeStudent(int rollNumber) {
	        for (Student student : studentList) {
	            if (student.getRollNumber() == rollNumber) {
	                studentList.remove(student);
	                return rollNumber;
	            }
	        }
			return -1;
	    }

	    public Student searchStudent(int rollNumber) {
	        for (Student student : studentList) {
	            if (student.getRollNumber() == rollNumber) {
	                return student;
	            }
	        }
	        return null;
	    }

	    public void displayAllStudents() {
	        for (Student student : studentList) {
	            System.out.println(student);
	        }
	    }
	    
	    public void writeToFile() {
	        try {
	        	FileOutputStream fos = new FileOutputStream(filePath);
	        	ObjectOutputStream outputStream = new ObjectOutputStream(fos);
	            outputStream.writeObject(studentList);
	            fos.close();
	            outputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void readFromFile() {
	        try{
	        	FileInputStream fis = new FileInputStream(filePath);
	        	ObjectInputStream inputStream = new ObjectInputStream(fis);
	        	studentList = (ArrayList<Student>) inputStream.readObject();
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	}

	public class  StudentManagementSystemMain extends StudentManagementSystem{
		
		public StudentManagementSystemMain(String filePath) {
			super(filePath);
		}

		private static final int maxAttempt =2;
		private static int count; 
		
		private void showInstruction()
		{
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
		}
		
		private void getChoice()
		{
			int choice=0;
			Scanner sc = new Scanner(System.in);
			while(choice<=0)
            {
	            try {
		            System.out.print("Enter your choice: ");
	            	choice = sc.nextInt();
	            }
	            catch(InputMismatchException e)
	            {
	            	System.out.println("Invalid input. Please enter a number.");
	            	sc.nextLine();
	            	count++;
	            	if(count==maxAttempt)
	            	{
	            		System.out.println("You Cross the Max Attempt Restart the program ");
	            		System.exit(0);
	            	}
	            }
            }
			 switch (choice) {
             case 1:
                 System.out.print("Enter student name: ");
                 sc.nextLine();
                 String name = sc.nextLine();
                 int rollNumber = 0;
                 while(rollNumber==0)
                 {
                     try {
                    	 System.out.print("Enter roll number: ");
                    	 rollNumber = sc.nextInt(); 
                     }
                     catch(InputMismatchException e){
     	            	System.out.println("Invalid input. Please enter a number.");
     	            	sc.nextLine();
     	            	count++;
     	            	if(count==maxAttempt)
     	            	{
     	            		writeToFile();
     	            		System.out.println("You Cross the Max Attempt Restart the program ");
     	            		System.exit(0);
     	            	}
                    	 
                     }
                 }
                 
                 System.out.print("Enter grade: ");
                 sc.nextLine(); // Consume newline
                 String grade = sc.nextLine();

                 Student newStudent = new Student(name, rollNumber, grade);
                 addStudent(newStudent);
                 System.out.println("Student added successfully!");
                 showInstruction();
                 getChoice();
             case 2:
                 int removeRollNumber =0 ;
                 while(removeRollNumber==0)
                 {
                     try {
                    	 System.out.print("Enter roll number to remove student: ");
                    	 removeRollNumber = sc.nextInt(); 
                     }
                     catch(InputMismatchException e){
     	            	System.out.println("Invalid input. Please enter a number.");
     	            	sc.nextLine();
     	            	count++;
     	            	if(count==maxAttempt)
     	            	{
     	            		writeToFile();
     	            		System.out.println("You Cross the Max Attempt Restart the program ");
     	            		System.exit(0);
     	            	}
                    	 
                     }
                 }
                 int AfterremovedRollNUmber = removeStudent(removeRollNumber);
                 if(AfterremovedRollNUmber>0)
                 	System.out.println("Student removed successfully!");
                 else
                 	System.out.println("There is no student associated with the provided roll number");
                 showInstruction();
                 getChoice();
             case 3:
                 System.out.print("Enter roll number to search student: ");
                 int searchRollNumber = sc.nextInt();
                 Student foundStudent = searchStudent(searchRollNumber);
                 if (foundStudent != null) {
                     System.out.println("Student found: " + foundStudent);
                 } else {
                     System.out.println("Student not found!");
                 }
                 showInstruction();
                 getChoice();
             case 4:
                 System.out.println("List of all students:");
                 displayAllStudents();
                 showInstruction();
                 getChoice();
             case 5:
                 System.out.println("Exiting Student Management System. Goodbye!");
                 writeToFile();
                 System.exit(0);
             default:
                 System.out.println("Invalid choice. Please enter a valid option.");
                 showInstruction();
                 getChoice();
                 
         }

			
		}
		
	    public static void main(String[] args) {
	        StudentManagementSystemMain sms = new StudentManagementSystemMain("/home/gods/Videos/codSoft/StudentManagementSystem.txt");
	        sms.readFromFile();
	        sms.showInstruction();
        	sms.getChoice();
	        
	}
	}


