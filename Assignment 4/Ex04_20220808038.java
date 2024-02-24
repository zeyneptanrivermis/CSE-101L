import java.util.Scanner;
public class Ex04_20220808038 {
public static void main(String[] args) {
		// 20220808038 Zeynep TANRIVERMİŞ
		
		Scanner scan = new Scanner(System.in);
		
		//Exercise 1
		System.out.println("Enter the center coordinates as integer:");
		int center_x = scan.nextInt();
		int center_y = scan.nextInt();
		System.out.println("Enter a point on the circle's edge:");
		int point_x = scan.nextInt();
		int point_y = scan.nextInt();
		double radius = Math.sqrt(Math.pow((center_x - point_x), 2)+(Math.pow(center_y - point_y, 2)));
		System.out.println("Area: " + Math.PI*Math.pow(radius, 2));
		System.out.println("Circumference: " + Math.PI*radius*2);
		
		//Exercise 2
		System.out.println("Enter your full name:");
		String full_name = scan.nextLine();
		int space = full_name.indexOf(" ");
		String name = full_name.substring(0,space);
		String surname = full_name.substring(space+1);
		System.out.println(surname + ", " + name);
		
		//Exercise 3
		System.out.println("Enter a day as number(1-7):");
		int number = scan.nextInt();
		switch(number) {
		case 1: System.out.println("Monday"); break;
		case 2: System.out.println("Tuesday"); break;
		case 3: System.out.println("Wednesday"); break;
		case 4: System.out.println("Thursday"); break;
		case 5: System.out.println("Friday"); break;
		case 6: System.out.println("Saturday"); break;
		case 7: System.out.println("Sunday"); break;
		default: System.out.println("ERROR"); break;
		}
		
		//Exercise 4
		System.out.println("Enter 3 city names:");
		String first_city = scan.next();
		String second_city = scan.next();
		String third_city = scan.next();
		char first_ch = first_city.charAt(0);
		char second_ch = second_city.charAt(0);
		char third_ch = third_city.charAt(0);
		int first_i = first_ch;
		int second_i = second_ch;
		int third_i = third_ch;
		if(first_i>second_i && first_i>third_i) {
			if(second_i>third_i) {
				System.out.println("Ascending order:");
				System.out.println(third_city);
				System.out.println(second_city);
				System.out.println(first_city);
			}
			else {
				System.out.println("Ascending order:");
				System.out.println(second_city);
				System.out.println(third_city);
				System.out.println(first_city);
			}
		}
		else if(second_i>first_i && second_i>third_i) {
			if(first_i>third_i) {
				System.out.println("Ascending order:");
				System.out.println(third_city);
				System.out.println(first_city);
				System.out.println(second_city);
			}
			else {
				System.out.println("Ascending order:");
				System.out.println(first_city);
				System.out.println(third_city);
				System.out.println(second_city);
			}
		}
		else if(third_i>first_i && third_i>second_i) {
			if(first_i>second_i) {
				System.out.println("Ascending order:");
				System.out.println(second_city);
				System.out.println(first_city);
				System.out.println(third_city);
			}
			else {
				System.out.println("Ascending order:");
				System.out.println(first_city);
				System.out.println(second_city);
				System.out.println(third_city);
			}
		}
		else {
			System.out.println("ERROR: INVALID INPUT!");
		}
		
		//Exercise 5
		System.out.println("Enter the height of triangle");
		double height_triangle = scan.nextDouble();
		System.out.println("Enter the base of triangle");
		double base_triangle = scan.nextDouble();
		double area_triangle = (height_triangle*base_triangle)/2.0;
		System.out.printf("Area: %.3f",area_triangle);

	}

}
