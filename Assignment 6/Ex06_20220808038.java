import java.util.Random;
import java.util.Scanner;
public class Ex06_20220808038 {

	public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	
        // Question 1
        int[] students = new int[10];
        for (int i = 0; i<students.length; i++) {
            students[i] = random(0, 100);
        }
        System.out.println("Scores of students:");
        display(students);
        char[] grades = grade(students);
        System.out.println("Grades of students are:");
        display(grades);

        // Question 2
        int[] numbers = new int[8];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random(0, 10);
        }
        display(numbers);
        System.out.println("Average of numbers is: " + average(numbers));
        double[] doubleNumbers = new double[8];
        for (int i = 0; i < doubleNumbers.length; i++) {
            doubleNumbers[i] = random(-0.5, 0.5);
        }
        display(doubleNumbers);
        System.out.println("Average of numbers is: " + average(doubleNumbers));

        // Question 3
        int[] numbers1 = new int[10];
        for (int i = 0; i < numbers1.length; i++) {
            numbers1[i] = random(0, 10, 1, 3, 5, 7, 9);
        }
        System.out.println("Generated numbers are: ");
        display(numbers1);

        // Question 4
        int[] numbers2 = new int[10];
        for (int i = 0; i < numbers2.length; i++) {
            numbers2[i] = random(0, 10, 0, 1, 3, 5, 7, 9);
        }
        System.out.println("Generated numbers with duplicate values are: ");
        display(numbers2);
        int[] nonDuplicateNumbers = eliminateDuplicates(numbers2);
        
        System.out.println("Non duplicate numbers");
        display(nonDuplicateNumbers);

        // Question 5
        int[] numbers11 = new int[10];
        for (int i = 0; i < numbers11.length; i++) {
            numbers11[i] = i;
        }
        System.out.println("is array in sorted order: " + isSorted(numbers11));
        display(numbers11);

        shuffle(numbers11);

        System.out.println("is array in sorted order: " + isSorted(numbers11));
        display(numbers11);
     
        // Question 6
        int n = 100;
        boolean[] lockers = new boolean[n];
        int[] openLockers = lockers(lockers);

        System.out.println("Open lockers are:");
        display(openLockers);

        System.out.println("for n == 100, open locker amount should be 10: open locker amount: " + openLockers.length);

        n = 1000;
        lockers = new boolean[n];
        openLockers = lockers(lockers);

        System.out.println("for n == 1000, open locker amount should be 31, open locker amount: " + openLockers.length);
    }

    // Question 1: Assign grades
    public static char[] grade(int[] students) {
    	// Question 1: Assign grades
    	char[] grades = new char[10];
    	int score = 0;
    	int best = getMax(students);
    	for(int i=0; i<students.length; i++) {
    		score = students[i];
    		if(score >= best - 10) {
    			grades [i] = 'A';
    		}
    		else if(score >= best - 20) {
    			grades [i] = 'B';
    		}
            else if(score >= best - 30) {
            	grades [i] = 'C';
    		}
            else if(score >= best - 40) {
            	grades [i] = 'D';
    		}
            else {
            	grades [i] = 'F';
            }
    	}
    	return grades;
    }

    // Finds the maximum value from the given array
    public static int getMax(int[] array) {
    	int best = array[0];
    	for(int i = 1; i<array.length; i++) {
    		if(best < array[i]) {
    			best = array[i];
    		}
    	}
    	return best;
    }

    // Question 2: Average an array
    public static int average(int[] array) {
    	int average = 0;
    	for(int i=0; i<array.length; i++) {
    		average += array[i];
    	}
    	average = average / array.length;
    	return average;
    }

    // Overload the above method for double data type
    public static double average(double[] array) {
    	double average = 0.0;
    	for(int i=0; i<array.length; i++) {
    		average += array[i];
    	}
    	average = average / array.length;
    	return average;
    }

    // Question 3: Random number chooser
    public static int random(int start, int end, int... exclude) {
    	int number = 0;
    	boolean isExcluded;
    	do {
    		isExcluded=false;
    		number = random(start, end);
    		for(int exc: exclude) {
    			if(exc==number) {
    				isExcluded=true;
    				break;
    			}
    		}
    	}while(isExcluded);
    	return number;
    }

    // Question 4: Eliminate duplicates
    public static int[] eliminateDuplicates(int[] array) {
    	int[] result_array = new int[array.length];
    	int index = 0;
        for (int i = 0; i < array.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                	System.out.print(array[i]);
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                result_array[index++] = array[i];
            }
        }
        System.out.println(" ");
    	return result_array;
    }	
    	
    // Question 5: Sorted?
    public static boolean isSorted(int[] array) {
    	boolean is_sort = false;
    	for(int i=0; i<array.length; i++) {
    		int a = i + 1;
    		if(array[i]<array[a]) {
    			is_sort = true;
    			break;
    		}
    		else {
    			is_sort = false;
    			break;
    		}
    	}
    	return is_sort;
    }

    // Shuffle the array randomly
    public static void shuffle(int[] array) {
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            swap(array, i, j);
        }
    }

    // Question 6: Locker puzzle
    public static int[] lockers(boolean[] locker) {
    	for(int i=0; i<locker.length; i++) {
    		locker[i]=false;
    	}
    	for(int student=1; student<=locker.length; student++) {
    		for(int j=1; j<=locker.length; j++) {
    			if(j%student==0) {
    				locker[j-1] = !locker[j-1];
    			}
    		}
    	}
    	int count = 0;
        for (boolean isOpen : locker) {
            if (isOpen) {
               count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < locker.length; i++) {
            if (locker[i]) {
                result[index] = i + 1; 
                index++;
            }
        }
        return result;
    }

    ////////////////////// HELPER FUNCTIONS //////////////////////
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void display(double[] array) {
        for (double i : array) {
            System.out.printf("%.1f\t", i);
        }
        System.out.println();
    }

    public static void display(int[] array) {
        for (int i : array) {
            System.out.printf("%d\t", i);
        }
        System.out.println();
    }

    public static void display(char[] array) {
        for (int i : array) {
            System.out.printf("%c\t", i);
        }
        System.out.println();
    }

    public static int random(int start, int end) {
        return start + (int) (Math.random() * (end - start + 1));
    }

    public static double random(double start, double end) {
        return start + Math.random() * (end - start + 1);
    }

    public static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

}
