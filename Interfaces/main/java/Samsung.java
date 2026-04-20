
public class Samsung implements Radio,Camera{

	@Override
	public void scanStation() {
		System.out.println(" Scanning the Station....");
	}
   @Override
	public void playStation() {
	   System.out.println(" Playing the Station...");	
	}
   @Override
   public void clickImage() {
	  System.out.println(" Clicking the Image...");
	
   }
   @Override
   public void showImage() {
	  System.out.println(" Showing the Image...");
	
   }

}
