public class Ex07_20220808038 {

    public static void main(String[] args) {
    	// Question 1
    	int[][] array2D = generateArray2D(4, 4, 0, 10);
        display2D(array2D);
        int diagonalSum = sumDiagonal(array2D);
        System.out.println("Sum of the diagonal for the given 2D array is: " + diagonalSum);
        
        //Question 2
        int[][] employees = generateArray2D(8, 7, 4, 9);
        display2D(employees);
        int[] workingHours = employeeWorkingHours(employees);
        display2D(employees);
        display(workingHours);
        
        // Question 3
        int[][] matrixA = generateArray2D(3, 2, 1, 10);
        int[][] matrixB = generateArray2D(2, 3, 1, 10);
        display2D(matrixA);
        display2D(matrixB);
        display2D(matmul(matrixA, matrixB));
        
        //Question 4
        //double[][] points = generateArray2D(12, 5, -0.3, 0.3);
        //display2D(points);
        //int[] closestPoints = getClosestPoints(points, 0);
        //System.out.println("Indexes of points with closest distance");
        //display(closestPoints);   
        
        // Question 5
        char[][] charArray2D = headsNtails(7);
        display2D(charArray2D);  
    }

    // Question 1: Sum the major diagonal in a matrix
    public static int sumDiagonal(int[][] array2D) {
    	int sum = 0;
    	for(int i=0; i<array2D.length; i++) {
    		sum += array2D[i][i];
    	}
    	return sum;
    }
    
 // Question 2: Compute the weekly hours for each employee
    public static int[] employeeWorkingHours(int[][] employees) {
        int[] a = new int[employees.length];
        int[] sum = new int[employees.length];
        for (int i = 0; i < employees.length; i++) {
            for (int j = 0; j < employees[i].length; j++) {
                sum[i] += employees[i][j];
            }
        }
        for (int k = 0; k < sum.length; k++) {
            for (int b = 0; b < sum.length; b++) {
                if (sum[k] > sum[b]) {
                    int temp = sum[k];
                    sum[k] = sum[b];
                    sum[b] = temp;
                }
            }
        }
        return sum;
    }
    
    // Question 3: multiply two matrices
    public static int[][] matmul(int[][] matrixA, int[][] matrixB) {
    	int m = matrixA.length;
        int n = matrixA[0].length;
        int k = matrixB[0].length;
        int[][] result = new int[m][k];
        for (int i=0; i<m; i++) {
            for (int j=0; j<k; j++) {
                int sum=0;
                for (int l=0; l<n; l++) {
                    sum += matrixA[i][l] * matrixB[l][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
    
    // Question 4: All closest pairs of points
    public static int[] getClosestPoints(double[][] points, int pointIndex) {
        double[] array = new double[points.length];
        double min = 99999;
        int count = 0;
        int[] array2 = new int[points.length];
        for(int i = 0; i < points.length; i++){
            array[i] = distance(points[i], points[pointIndex]);
            if(i != pointIndex){
                if(array[i] <= min){
                    min = array[i];
                }
            }
        }
        for(int j = 0; j < array.length; j++){
               if(pointIndex!= j){
                 if(array[j] == min) {
                    array2[count] = j;
                    count++;
                }
            }
        }
        int n = 0;
        int[] array3 = new int[count];
        for (int k = 0; k < array3.length; k++) {
            array3[n] = array2[k];
            if (array2[k] != 0) {
                n++;
            }
        }
        return array3;
    }

    // Calculates the euclidean distance between two points in d dimensional space
    public static double distance(double[] pointA, double[] pointB) {
        double a = 0;
        double[] array = new double[pointA.length];
        for (int i = 0; i < pointB.length; i++){
            array[i] = Math.pow(pointA[i] - pointB[i],2);
            a += array[i];
        }
        return Math.sqrt(a);
    }
    
    // Question 5: Nine heads and tails <<<
    public static char[][] headsNtails(int number) {
    	char[][] array = new char[3][3];
    	String binary = Integer.toBinaryString(number);
    	while (binary.length() < 9) {
    	    binary = "0" + binary;
    	}
    	int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char binary_char = binary.charAt(index++);
                if (binary_char == '0') {
                    array[i][j] = 'H';
                } else {
                    array[i][j] = 'T';
                }
            }
        }
    	return array;
    }
 
    /////////////// HELPER METHODS ////////////////////////////

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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

    public static void display2D(int[][] array2D) {
        for (int[] row : array2D) {
            display(row);
        }
        System.out.println("--------------------------");
    }


    public static void display2D(char[][] array2D) {
        for (char[] row : array2D) {
            display(row);
        }
        System.out.println("--------------------------");
    }

    public static int[][] generateArray2D(int m, int n, int start, int end) {
        int[][] array2D = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array2D[i][j] = random(start, end);
            }
        }

        return array2D;
    }

    public static int random(int start, int end) {
        return start + (int) (Math.random() * (end - start + 1));
    }

    public static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}