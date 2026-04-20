import java.util.Scanner;

public class UserScanningvalues {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" Enter name : ");
		String name = sc.next();
		System.out.println("Scanned Name is : "+name); 
		
		System.out.println("Enter Age : ");
		int age = sc.nextInt();
		System.out.println(" Age is : "+age);

	}

}
