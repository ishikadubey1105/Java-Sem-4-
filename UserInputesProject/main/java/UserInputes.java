import java.util.Scanner;

public class UserInputes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name : ");
		String name = sc.nextLine();
		System.out.println(" Name is : "+name);
		
		System.out.println(" Enter Age : ");
		int age  =  sc.nextInt();
		System.out.println(" Age is : "+age);
		
		System.out.println("Enter Salary : ");
		double salary = sc.nextDouble();
		System.out.println(" Salary is : "+salary);
		
		}

}
