package CodeSoft;

import java.util.ArrayList;
import java.util.Scanner;

public class StudGradeCalculator {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println();
		
		System.out.println("*Welcome to the Student Grade Calculator Tool*");
		
		System.out.println();
		String ex = "";
		ArrayList<Stud> list = new ArrayList<>();
		do {
		System.out.print("Enter your name: ");
		String name = sc.next();
		System.out.print("Enter the number of subjects you have : ");
		
		int n = sc.nextInt();
		int sum=0;
		System.out.println();

		System.out.println("Please enter the marks you obtained for all "+n+" subjects out of 100");

		
		for(int i=1; i<=n; i++) {
			
			System.out.print("Subject "+i+" : ");
			int j = sc.nextInt();
			
			if(j<0 || j>100) {
				System.out.println("Your mark can't be negative and not exceed");
				System.out.println("Try again");
				continue;
			}
			sum+=j;
			
		}

		double avg = sum/n;
		String c = "";
			
		if(avg>=90 && avg<=100) {
			c="A+";
		}
		else if(avg>=80 && avg<=89) {
			c="A";
		}
		else if(avg>=70 && avg<=79) {
			c="B+";
		}
		else if(avg>=60 && avg<=69) {
			c="B";
		}
		else if(avg>=50 && avg<=59) {
			c="C+";
		}
		else if(avg>=40 && avg<=49) {
			c="C";
		}
		else {
			c="FAIL";
		}
		
		Stud student = new Stud(name , sum , avg , c , n);
		list.add(student);
		System.out.println("Your total mark : "+sum+" out of "+n*100);
		System.out.println("Your percentage : "+avg+"%");
		System.out.println("Your Grade : "+c);
		System.out.println();
		System.out.println("++++++++++++++++++++++Your calculated history+++++++++++++++++++++++++");
		System.out.println("---------------------------------------------------------------");
		System.out.printf("%7s %15s  %15s %15s %10s", "NAME" , "TOTAL MARK" , "TOTAL SUBJECT" , "PERCENTAGE" , "GRADE");
		System.out.println();
		for(Stud el : list) {
			
			System.out.format("%8s %12s  %12s %16s %14s", el.name , (el.total)+"/"+(el.subjects*100) , el.subjects , el.percentage+"%" , el.grade);
			System.out.println();
		}
		System.out.println("---------------------------------------------------------------");
		System.out.println();
		System.out.print("Do you want to calculate again ? (yes/no) ");
		ex = sc.next();
		}while(ex.toLowerCase().equals("yes"));
		
		System.out.println("Thank You!!");
	}

}

class Stud{
	String name;
	int total;
	double percentage;
	String grade;
	int subjects;
	
	Stud(String name , int sum , double average , String c , int n){
		
		this.name = name;
		total = sum;
		percentage = average;
		grade = c;
		subjects = n;
	}
}