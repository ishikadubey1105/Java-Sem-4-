
public class StudentMain {

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setPRN_No(1);
		s1.setStud_Name("Abc");
		s1.setStude_Dept("CSE");
		
		int rollno = s1.getPRN_No();
		String name = s1.getStud_Name();
		String dept = s1.getStude_Dept();

	}

}
