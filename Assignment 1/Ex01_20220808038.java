
public class Ex01_20220808038 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Exercise 1
		
		System.out.println("a \t a^2 \t a^3");
		System.out.println("1 \t 1 \t 1");
		System.out.println("2 \t 8 \t 4");
		System.out.println("3 \t 9 \t 27");
		System.out.println("4 \t 16 \t 64");
		System.out.println("");
		
		//Exercise 2 
		
		double z = (9.5*4.5 - 2.5*3) / (45.5 - 3.5);
		System.out.println("Z= " + z);
		System.out.println("");
		
		//Exercise 3 
		
		double pi = 4*(1- 1.0/3 + 1.0/5 -1.0/7 + 1.0/9 - 1.0/11);
		System.out.println("Pi= " + pi);
		double pi2 = 4*(1- 1.0/3 + 1.0/5 - 1.0/7 + 1.0/9 - 1.0/11 + 1.0/13);
		System.out.println("Pi2= " + pi2);
		System.out.println("");
		
		//Exercise 4
		
		double area = pi*5.5*5.5;
		System.out.println("Area of the circle= " + area);
	    double perimeter = 2*pi*5.5;
	    System.out.println("Perimeter of the circle= " + perimeter);
	    System.out.println("");
		
		//Exercise 5
		
		double x = (44.5*0.55 - 50.2*5.9) / (3.4*0.55 - 50.2*2.1);
		double y = (3.4*5.9 - 44.5*2.1) / (3.4*0.55 - 50.2*2.1);
		System.out.println("X= " + x);
		System.out.println("Y= " + y);
		double n = (3.4*x + 50.2*y) + (2.1*x + 0.55*y);
		System.out.println("E+F= " + n);

	}
}
