
public class StudentMain {

	public static void main(String[] args) {
		Student s1  = new Student();
//		s1.setRollNo(100);
//		s1.setStudName("Abc");
//		s1.setStudBranch("AI");
		System.out.println(s1.getRollNo());
		System.out.println(s1.getStudName());
		System.out.println(s1.getStudBranch());
		
		Student s2  =  new Student(101,"Xyz","CSE");
		System.out.println(s2.getRollNo());
		System.out.println(s2.getStudName());
		System.out.println(s2.getStudBranch());
	}

}
