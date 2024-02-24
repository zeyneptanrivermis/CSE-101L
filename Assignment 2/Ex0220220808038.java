import java.util.Scanner;

		public class Ex0220220808038 {

			public static void main(String[] args) {
				// TODO Auto-generated method stub
				
				// Zeynep TANRIVERMİŞ 20220808038
				
				Scanner scan = new Scanner(System.in);
				
				// Exercise 1
				
				System.out.println("Enter a integer value: ");
				int value = scan.nextInt();
				int result;
				
				if(value<10 && value>-10) {
					result = 0;
					System.out.println("The second to last digit of the entered integer is " + result);
				}
				
				else {
					result = (value/10)%10;
					System.out.println("The second to last digit of the entered integer is" + result);
				}
				// Exercise 2
				
				System.out.println("Please enter the minute you have been using the charger:");
				int minute = scan.nextInt();
				
				int amount;
				double overpaid_amount;
				double remaining_minute;
				
				
				if(minute%60==0) {
					amount = (minute/60)*50;
					overpaid_amount = 0;
					remaining_minute = 0;
					System.out.println("Total Amount: " + amount);
					System.out.println("Overpaid Amount: " + overpaid_amount);
					System.out.println("Remaining Time: " + remaining_minute);		}
				
				else {
					amount = (minute/60+1)*50;
					remaining_minute = (minute/60+1)*60 - minute;
					overpaid_amount = remaining_minute*60/50;
					System.out.println("Total Amount: " + amount);
					System.out.println("Overpaid Amount: " + overpaid_amount);
					System.out.println("Remaining Minute: " + remaining_minute);
				}
				
				// Exercise 3
				
				System.out.println("Please enter the number of trials: ");
				int trial = scan.nextInt();
				double probability = Math.pow((1-1.0/6), (trial-1));
				
				if(probability==0) {
					System.out.println("ERROR: Probability cannot be negative value.");
				}
				
				else {
					System.out.println("The probability of rolling the first 4 on trial " + trial + " is " + probability);
				}
			}

		}

