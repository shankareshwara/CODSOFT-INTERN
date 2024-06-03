package CodeSoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

class Course{
	
	int courseCode = 0;
	String courseTittle;
	String description;
	int capacity;
	String schedule;
	
	Course( int courseCode ,String courseTittle , String description , int capacity , String schedule){
		
		this.courseCode = courseCode;
		this.courseTittle = courseTittle;
		this.description = description;
		this.capacity = capacity;
		this.schedule = schedule;
	}
	
}

class Student{
	
	static int Id = 0;
	int studentId = 0;
	String name;
	ArrayList<String> registeredCourse;
	public Student(String name, ArrayList<String> List) {
		this.studentId = Id+1;
		Id++;
		this.name = name;
		registeredCourse = List;
		
	}
	
}
public class CourseManagementSystem {
		
	public static void main(String[] args) {
		
		Scanner x = new Scanner(System.in);
		
		LinkedHashMap<String , Course> course = setCourse();
		LinkedHashMap<Integer, Student> student= setStudent();
		
		while(true) {
		System.out.println("Role Menu");
		System.out.println("1.admin");
		System.out.println("2.student");
		System.out.println("3.Exit");


		System.out.print("Enter Your option (1 or 2 or 3):");
		int choice = x.nextInt();
		
		switch(choice) {
			case 1:
			{
				AdminChoice(course , student);

			}
			break;
			case 2:
			{
				studentChoice(course , student);
			}
			break;
			case 3:
			{
				System.out.println("Thank You!!");
				return;

			}
			default:
			{
				System.out.println("Please Enter Correct option!");

			}
		}
		}
		
	}

	private static void AdminChoice(LinkedHashMap<String, Course> course, LinkedHashMap<Integer, Student> student) {
		
		Scanner x = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("ADMIN MENU");
			System.out.println("1.Student Details");
			System.out.println("2.Course Details");
			System.out.println("3.Exit");
			
			System.out.print("Enter your Option: ");
			int choice = x.nextInt();
			
			switch(choice) {
				case 1:
				{
					studentTable(student);
//					System.out.println("hello");
				}
				break;
				case 2:
				{
					courseTable(course);
				}
				break;
				case 3:
				{
					System.out.println("Thank You!!");
					return;

				}
				default:
					System.out.println("Please Enter Correct option!");
				
			}
			
		}

		
	}

	private static void studentTable(LinkedHashMap<Integer, Student> student) {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("%5s %10s %25s", "STUDENT ID", "NAME", "REGISTERED COURSE");
		System.out.println();
		for(int id : student.keySet()) {
			
			Student stud = student.get(id);
			
			String RCourse = "";
			for(String str : stud.registeredCourse) {
				RCourse += str+" ";
			}
			if(RCourse.isEmpty()) {
				RCourse = "NULL";
			}
			System.out.format("%5s %16s %15s", stud.studentId , stud.name , RCourse);
			System.out.println();
		}
		System.out.println("---------------------------------------------------------------");

		
	}

	private static void courseTable(LinkedHashMap<String, Course> course) {
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("Course Code "+"     "+"Course Tittle"+"        "+"description"+"        "+"capacity"+"     "+"Schedule");

			for(String tittle : course.keySet()) {
				Course c = course.get(tittle);
				System.out.format("%7s %17s %27s %7s %15s",c.courseCode ,c.courseTittle,c.description,c.capacity,c.schedule);
				System.out.println();
				
			}
			System.out.println("------------------------------------------------------------------------------------------");

		
		
	}

	private static void studentChoice(HashMap<String, Course> course, HashMap<Integer, Student> student) {
		
		Scanner x = new Scanner(System.in);
		System.out.println("WELCOME TO COURSE REGISTRATION PLATFORM");
		System.out.print("Enter your ID: ");
		int id = x.nextInt();
		if(!student.containsKey(id)) {
			System.out.println("Your ID not found");
			return;
		}
		
		System.out.println("Hello "+student.get(id).name+"!!");
		
		while(true) {
			
			System.out.println("STUDENT MENU");
			System.out.println("1.Available Course");
			System.out.println("2.Course Registration");
			System.out.println("3.Drop Course");
			System.out.println("4.Exit");

			System.out.print("Enter your Option: ");
			int choice = x.nextInt();
			
			switch(choice) {
				case 1:
					viewAvailableCourse(course);
					break;
				case 2:
				{
					System.out.print("Enter course Name: ");
					String courseName = x.next();
					CourseRegistration(course , student , id , courseName);
				}
					break;
				case 3:
				{

					System.out.print("Enter course Name: ");
					String courseName = x.next();
					dropCourse(student , course , id , courseName);
				}
					break;
				case 4:
				{
					System.out.println("Thank You!!");
					return;

				}
				default:
					System.out.println("Please Enter Correct option!");
			}
			
			
		}
		
	}
	private static void dropCourse(HashMap<Integer, Student> student, HashMap<String, Course> course, int id, String courseName) {
		
		if(student.get(id).registeredCourse.contains(courseName)) {
			
			student.get(id).registeredCourse.remove(courseName);
			course.get(courseName).capacity++;
			System.out.println(courseName+" course droped successfully");

		}
		else {
			System.out.println("You not registerd for "+courseName+" course");
			return;
		}
		
	}

	private static void CourseRegistration(HashMap<String, Course> course, HashMap<Integer, Student> student , int id , String courseName) {
		
		courseName = courseName.toLowerCase();
		
		if(!course.containsKey(courseName)) {
			System.out.println("No course available in this course name");
			return;
		}
		if(student.get(id).registeredCourse.contains(courseName)) {
			System.out.println("You already registed");
			return;
		}
		
		if(course.get(courseName).capacity <= 0) {
			System.out.println("Course capacity is full for "+courseName+" course");
		}
		else {
			course.get(courseName).capacity -= 1;
			
			
			student.get(id).registeredCourse.add(courseName);
			
			System.out.println("SuccessFully Registered for "+courseName+" course");
		}
		
	}

	private static void viewAvailableCourse(HashMap<String, Course> course) {
		
		boolean available = false;
		
		for(String tittle : course.keySet()) {
			
			if(course.get(tittle).capacity > 0) {
				Course c = course.get(tittle);
				if(!available) {
					System.out.println("------------------------------------------------------------------------------------------");
					System.out.println("Course Code "+"     "+"Course Tittle"+"        "+"description"+"        "+"capacity"+"     "+"Schedule");
					available = true;
				}
				
				System.out.format("%7s %17s %27s %7s %15s",c.courseCode ,c.courseTittle,c.description,c.capacity,c.schedule);
				System.out.println();
				
			}
		}
		
		if(!available) {
			System.out.println("SORRY NO COURSES AVAILABE");
		}
		else {
			System.out.println("------------------------------------------------------------------------------------------");

		}

	}

	private static LinkedHashMap<String, Course> setCourse() {
		
		Course course1 = new Course(1,"java" , "programing subject" , 3 , "17 may");
		Course course2 = new Course(2,"c" , "programing subject" , 3 , "18 may");
		Course course3 = new Course(3,"c++" , "programing subject" , 3 , "19 may");
		LinkedHashMap<String , Course> map = new LinkedHashMap<>();
		
		map.put(course1.courseTittle, course1);
		map.put(course2.courseTittle, course2);
		map.put(course3.courseTittle, course3);

		return map;
	}
	
	private static LinkedHashMap<Integer, Student> setStudent() {
		
		Student student1 = new Student("shankar" , new ArrayList<String>());
		Student student2 = new Student("sam" , new ArrayList<String>());
		Student student3 = new Student("karthick" , new ArrayList<String>());
		LinkedHashMap<Integer , Student> map = new LinkedHashMap<>();
		
		map.put(student1.studentId, student1);
		map.put(student2.studentId, student2);
		map.put(student3.studentId, student3);

		return map;
	}
}
