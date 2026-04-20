import java.util.Scanner;

public class UserInput {
  
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter Name");
		String name = sc.next();
		System.out.println(" Name is  : "+name);
		
		System.out.println(" Enter Age");
		int age = sc.nextInt();
		System.out.println(" Age is  : "+age);
		
		System.out.println(" Enter Salary");
		double salary = sc.nextDouble();
		System.out.println(" Salary is  : "+salary);
		
	/*	int arr[] = new int[5];
		System.out.println(" Please Enter Element's of Array");
		for(int i=0;i<arr.length;i++)
		{
			Scanner sc = new Scanner(System.in);
			int num  = sc.nextInt();
			arr[i] = num;	
		} */
		
	 
		

	}

}
