
public class ExceptionExample1 {

	public static void main(String[] args) {
		int a = 10;
		int b= 0;
		try {
		int c = a/b;
		System.out.println(" Division is : "+c);
		}
		catch(Exception e)
		{
			System.out.println("{ Exception Handled : "+e);
		}
		System.out.println(" The End..");

	}

}
