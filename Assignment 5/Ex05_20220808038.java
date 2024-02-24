// Zeynep Tanrivermis 20220808038
import java.util.Scanner;
public class Ex05_20220808038 {
	
	//Method of the first exercise
	public static double computePI(int number) {
		double total = 0.0;
		for(int i=1; i<=number; i++) {
			total += Math.pow(-1.0, (i+1))/(2*i-1);
		}
		double pi = total *4;
		return pi;
	}
	
    //Method of the second exercise
	public static int factorial (int number) {
		int result=1;
		for(int i=1; i<=number; i++) {
			result *= i;
		}
		return result;
	}
	
    //Method of the third a exercise
	public static Boolean isPrime (int number) {
		if(number==2) {
			return true;
		}
		for(int i=2; i<number; i++) {
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}

	//Method of the third b exercise
	public static void nPrimes(int number) {
		Scanner reader = new Scanner(System.in);
		int count = 0, i = 2;
		System.out.println("Enter how many prime number you want:");
		number = reader.nextInt();
		while(count<number) {
			if(isPrime(i)==true) {
				count++;
				System.out.println(count + ". Number:" + i);
			}
			i++;
		}	
	}
	
	
    //Method of the fourth exercise
	public static void nPerfectNumbers(int n) {
		Scanner scanner = new Scanner(System.in);
		int k = 6, sum = 0, count = 0;
		System.out.println("Enter number of data: ");
		n = scanner.nextInt();
		do{
			for(int i=1; i<k; i++) {
				if(k%i==0) {
					sum += i;
				}
			}
			if(sum==k) {
				count++;
				System.out.println("Number " + count + ": " +k);
			}
			k++;
			sum = 0;
		}while(count<=n);
	}
	
    //Method of the fifth exercise
	public static void displayStatistics (int n) {
		Scanner input = new Scanner(System.in);
		double mean=0.0, deviation=0.0;
		double total_sum=0.0, total_sum2=0.0, data_point = 0.0;
		System.out.println("Enter number of data: ");
		n = input.nextInt();
		for(int i=1; i<=n; i++) {
			System.out.println("Enter " + i + " data points as a double: ");
			data_point = input.nextDouble();
			total_sum += data_point;
			total_sum2 += Math.pow(data_point, 2);
		}
		mean = total_sum/n;
		deviation = Math.sqrt((total_sum2 - n * Math.pow(mean, 2)) / (n - 1));
		System.out.printf("Mean: %.2f%n", mean);
		System.out.printf("Standard Deviation: %.5f%n", deviation);
	}
	
	
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	//First Exercise
	System.out.println("Enter an integer:");
	int a = scan.nextInt();
	if(a<0) {
		do {
			System.out.println("ERROR: You cannot enter a negative value!");
			System.out.println("Enter an integer:");
			a = scan.nextInt();
		}while(a<0);
		if(a==0) {
			System.out.println("PI: 3");
		}
		else {
			System.out.println("PI: " + computePI(a));
		}
	}
	else if(a==0) {
		System.out.println("PI: 3");
	}
	else {
		System.out.println("PI: " + computePI(a));
	}
	
    //Second Exercise
	System.out.println("Enter an integer:");
	int b = scan.nextInt();
	if(b<0) {
		do {
			System.out.println("ERROR: You cannot enter a negative value!");
			System.out.println("Enter an integer:");
			b = scan.nextInt();
		}while(b<0);
		if(b==0) {
			System.out.println("Factorial of the number: 1");
		}
		else {
			System.out.println("Factorial of the number: " + factorial(b));
		}
	}
	else if(b==0) {
		System.out.println("Factorial of the number: 1");
	}
	else {
		System.out.println("Factorial of the number: " + factorial(b));
	}
	
    //Third a Exercise
	System.out.println("Enter an integer:");
	int c = scan.nextInt();
	if(c<=1) {
		do {
			System.out.println("ERROR: You have to enter a number"
					+ " which greater than 1!");
			System.out.println("Enter an integer:");
			c = scan.nextInt();
		}while(c<=1);
	}
	isPrime(c);
	if(isPrime(c)==true) {
		System.out.println("The number is a prime number.");
	}
	else {
		System.out.println("The number is not a prime number.");
	}
	
	//Third b Exercise
	nPrimes(5);
	
    //Fourth Exercise
	nPerfectNumbers(3);
    
	
    //Fifth Exercise
	displayStatistics(1);

	}

}
