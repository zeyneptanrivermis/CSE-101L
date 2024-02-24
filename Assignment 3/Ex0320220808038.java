import java.util.Scanner;

public class Ex0320220808038 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Zeynep TANRIVERMİŞ 20220808038
		
		Scanner scan = new Scanner(System.in);
				
		//Exercise 1	
		System.out.println("A restaurant has these meals and drinks:");
		System.out.println("ID \t MEAL \t PRICE");
		System.out.println("1 \t Doner \t 80");
		System.out.println("2 \t Kebab \t 110");
		System.out.println("3 \t Lahmacun \t 75");
		System.out.println("ID \t DRINK \t PRICE");
		System.out.println("1 \t Ayran \t 10");
		System.out.println("2 \t Kola \t 20");
		System.out.println("3 \t Salgam \t 15");
		System.out.println("Please enter ID of the meal you want:");
		int meal = scan.nextInt();
		System.out.println("Please enter ID of the drink you want:");
		int drink = scan.nextInt();
		if(meal==1) {
			if(drink==1) {
				System.out.println("Doner and Ayran 90.");
			}
			else if(drink==2) {
				System.out.println("Doner and Kola 100.");
			}
			else if(drink==3) {
				System.out.println("Doner and Salgam 95.");
			}
			else {
				System.out.println("ERROR: Invalid value.");
			}
		}
		
		if(meal==2) {
			if(drink==1) {
				System.out.println("Kebab and Ayran 120.");
			}
			else if(drink==2) {
				System.out.println("Kebab and Kola 130.");
			}
			else if(drink==3) {
				System.out.println("Kebab and Salgam 125.");
			}
			else {
				System.out.println("ERROR: Invalid value.");
			}
		}
		
		if(meal==3) {
			if(drink==1) {
				System.out.println("Lahmacun and Ayran 85.");
			}
			else if(drink==2) {
				System.out.println("Lahmacun and Kola 95.");
			}
			else if(drink==3) {
				System.out.println("Lahmacun and Salgam 90.");
			}
			else {
				System.out.println("ERROR: Invalid value.");
			}
		}
		
		else {
			System.out.println("ERROR: Invalid value.");
		}

		//Exercise 2
		
		System.out.println("Please choose your membership type: ");
		System.out.println("Type 1: 100 GB quota for 80TL and 3 TL per GB use with 15% tax");
		System.out.println("Type 2: 200 GB quota for 140 TL and 5 TL per GB use with 10% tax");
		int type = scan.nextInt();
		System.out.println("Enter your internet usage as GB: ");
		int usage = scan.nextInt();
		double total_amount;
		int extra_usage;
		
		if(type==1) {
			if(usage<0) {
				System.out.println("ERROR: Internet usage cannot be a negative value.");
			}
			else {
				extra_usage = usage-100;
				total_amount = (80+(extra_usage*3))*115/100;
				System.out.println("Total Amount = " + total_amount);
			}
		}
		
		else if(type==2){
			if(usage<0) {
				System.out.println("ERROR: Internet usage cannot be a negative value.");
			}
			else {
				extra_usage = usage-200;
				total_amount = (140+(extra_usage*5))*110/100;
				System.out.println("Total Amount = " + total_amount);
			}
		}
		
		else {
			System.out.println("ERROR: Type has to be 1 or 2.");
		}
		
		// Exercise 3
		System.out.println("Choose your attack:");
		int attack = scan.nextInt();
		System.out.println("Choose your first coin(0-tail, 1-head, 2-deciding with Math.random()):");
		int coin1 = scan.nextInt();
		System.out.println("Choose your second coin(0-tail, 1-head, 2-deciding with Math.random()):");
		int coin2 = scan.nextInt();
		int toss1, toss2;
		if(attack==1) {
			if(coin1==0) {
				if(0<=coin2 && coin2<=2) {
					System.out.println("Damage: 0");
				}
				else {
					System.out.println("ERROR: Invalid value.");
				}
			}
			else if(coin1==1) {
				if(coin2==0) {
					System.out.println("Damage: 0");
				}
				else if(coin2==1) {
					System.out.println("Damage: 60");
				}
				else if(coin2==2) {
					toss2 = (int)(Math.random()*2);
					if(toss2==1) {
						System.out.println("Damage: 60");
					}
					else {
						System.out.println("Damage: 0");
					}
				}
				else {
					System.out.println("ERROR: Invalid value.");
				}
			}
			else if(coin1==2) {
				if(coin2==0) {
					System.out.println("Damage: 0");
				}
				else if(coin2==1) {
					toss1 = (int)(Math.random()*2);
					System.out.println("Damage: 60");
				}
				else if(coin2==2) {
					toss1 = (int)(Math.random()*2);
					toss2 = (int)(Math.random()*2);
					if(toss1==1 && toss2==1) {
						System.out.println("Damage: 60");
					}
					else {
						System.out.println("Damage: 0");
					}
				}
				else {
					System.out.println("ERROR: Invalid value.");
				}
			}
		}
		else if(attack==2) {
			if(coin1==0) {
				if(coin2==0) {
					System.out.println("Damage: 50");
				}
				else {
					System.out.println("ERROR: Invalid value.");
				}
			}
			else if(coin1==1) {
				if(coin2==0) {
					System.out.println("Damage: 70");
				}
				else if(coin2==1) {
					System.out.println("Damage: 90");
				}
				else if(coin2==2) {
					toss2 = (int)(Math.random()*2);
					if(toss2==1) {
						System.out.println("Damage: 90");
					}
					else {
						System.out.println("Damage: 70");
					}
				}
				else {
					System.out.println("ERROR: Invalid value.");
				}
			}
			else if(coin1==2) {
				if(coin2==0) {
					toss1 = (int)(Math.random()*2);
					if(coin1==1) {
						System.out.println("Damage: 70");
					}
					else {
						System.out.println("Damage: 0");
					}
				}
				else if(coin2==1) {
					toss1 = (int)(Math.random()*2);
					if(coin1==1) {
						System.out.println("Damage: 90");
					}
					else {
						System.out.println("Damage: 70");
					}
				}
				else if(coin2==2) {
					toss1 = (int)(Math.random()*2);
					toss2 = (int)(Math.random()*2);
					if(toss1==1 && toss2==1) {
						System.out.println("Damage: 90");
					}
					else if(toss1==1 || toss2==1) {
						System.out.println("Damage: 70");
					}
					else {
						System.out.println("Damage: 50");
					}
				}
				else {
					System.out.println("ERROR: Invalid value.");
				}
			}
		}
		else {
			System.out.println("ERROR: Invalid value.");
		}
	}

}
