
public class Student {
     private int rollNo;
     private String studName;
     private String studBranch;
     public Student() // DEFAULT CONSTRUCTOR
     {
    	 rollNo = -1;
    	 studName = "NA";
    	 studBranch = "NA";
     }
     
     public Student(int rollNo,String studName,String studBranch)  // PARAMETERIZED CONSTRUCTOR
     {
    	 System.out.println(" Inside Parameterized Constructor...");
    	 this.rollNo = rollNo;
    	 this.studName = studName;
    	 this.studBranch = studBranch;
     }
     
     
     
	 public int getRollNo() {
		 return rollNo;
	 }
	 public void setRollNo(int rollNo) {
		 this.rollNo = rollNo;
	 }
	 public String getStudName() {
		 return studName;
	 }
	 public void setStudName(String studName) {
		 this.studName = studName;
	 }
	 public String getStudBranch() {
		 return studBranch;
	 }
	 public void setStudBranch(String studBranch) {
		 this.studBranch = studBranch;
	 }
     
}
