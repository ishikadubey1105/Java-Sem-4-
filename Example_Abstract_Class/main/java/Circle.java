
public class Circle extends Shape{
    final double PI = 3.14;
    double radius = 20.10;
    double a;
	@Override
	public void area() {
		a = PI*radius*radius;
		System.out.println(" Area is : "+a);
	}

}
