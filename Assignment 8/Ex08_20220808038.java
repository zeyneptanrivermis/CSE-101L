// Zeynep TANRIVERMİŞ
// 01.01.2024
import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Ex08_20220808038 {
    public static void main(String[] args) throws FileNotFoundException {
    	// Question 1
    	intLogger("file_1.txt");
    	
    	// Question 2
        display(intReader("file_1.txt"));
    	
    	// Question 3
        replaceNumbers("file_1.txt","file_2.txt", 100, 255);
    	
    	// Question 4
    	readSortPokeStats("PokeStats1.txt", "SortedPokeStats.txt");

    	// Question 5
    	
    	// Question 6

    }

    // Question 1: Log unspecified number of integers
    public static void intLogger(String filename) {
        File file = new File(filename);
        try {
            Scanner scan = new Scanner(System.in);
            FileWriter writer = new FileWriter(file);
            System.out.println("Enter inputs:");
            int number = 0;
            do {
                try {
                    number = scan.nextInt();
                    writer.write(String.valueOf(number) + "\n");
                } 
                catch (InputMismatchException e) {
                    scan.next();
                    writer.write("non-integer-input \n");
                }
            } while (number != 0);
            writer.close(); 
            scan.close(); 
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    	
    // Question 2: Read Integers from the Log File.
    public static int[] intReader(String filename) {
    	int[] result = null; 
        try (Scanner reader = new Scanner(new File(filename))) {
            int count = 0;
            while (reader.hasNext()) {
                String token = reader.next();
                try {
                    Integer.parseInt(token); 
                    count++; 
                } 
                catch (NumberFormatException e) {
                }
            }
            result = new int[count]; 
            reader.close(); 
            Scanner newreader = new Scanner(new File(filename)); 
            int index = 0;
            while (newreader.hasNext()) {
                String token = newreader.next();
                try {
                    int number = Integer.parseInt(token); 
                    result[index++] = number; 
                } 
                catch (NumberFormatException e) {
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (InputMismatchException e) {
            System.out.println("Input mismatch in file: " + filename);
        }
        return result;
    }
    
    // Question 3: Replace Specific Numbers in the Log File
    public static void replaceNumbers(String filename1, String filename2, int oldNum, int newNum) {
    	try (Scanner reader = new Scanner(new File(filename1));
             PrintWriter writer = new PrintWriter(new File(filename2))) {
            while (reader.hasNext()) {
                if (reader.hasNextInt()) {
                    int a = reader.nextInt();
                    if (a == oldNum) {
                        writer.println(newNum);
                    } 
                    else {
                        writer.println(a);
                    }
                } 
                else {
                    reader.next();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename1);
        } catch (InputMismatchException e) {
            System.out.println("Input mismatch in file: " + filename1);
        }
    }

    // Question 4: Read and Sort Pokémon Stats Data 
    public static void readSortPokeStats(String datafile, String sortedfile) throws FileNotFoundException {
    	File file1 = new File(datafile); 
        File file2 = new File(sortedfile);
        int line_count = 0;
        try (Scanner reader = new Scanner(file1)) {
            while(reader.hasNextLine()){
                line_count++;
            }
            String[][] array = new String[line_count][];
            reader.close();
            Scanner reader_1 = new Scanner(file1);
            for (int i = 0; i < line_count; i++) {
                array[i] = reader_1.nextLine().split("\\s+");
            }
            Arrays.sort(array, (a, b) -> {
                int totalA = 0;
                int totalB = 0;
                for (int i = 3; i < a.length; i++) {
                    totalA += Integer.parseInt(a[i]);
                    totalB += Integer.parseInt(b[i]);
                }
                return Integer.compare(totalB, totalA); 
            });
            try (PrintWriter writer = new PrintWriter(file2)) {
                for (String[] row : array) {
                    writer.println(String.join(" ", row));
                }
            } 
            catch (FileNotFoundException e) {
                System.out.println("Error writing to file: " + sortedfile);
            }
        }
    }     
   
        /*
         * Write a method that reads pokemon data from a file and sort pokémons
         *  by their total base stats in descending order and writes the sorted
         *  data on a new file in the same format.
         * Data Header in the file is: "Name Type1 Type2 HP Attack Defense Sp.Atk Sp.Def Speed"
         * Your method must handle FileNotFoundException
         * Exception handling message should take only one line in console.
         * 
         * 
         * Args:
         *      datafile: String that specifies the target data file.
         *      sortedfile: String that specifies the new data file that 
         *          will contain the sorted data.
         * 
         */
        /*
     * Example Pokémon Data:
Name Type1 Type2 HP Attack Defense Sp.Atk Sp.Def Speed
Bulbasaur Grass Poison 45 49 49 65 65 45
Ivysaur Grass Poison 60 62 63 80 80 60
Venusaur Grass Poison 80 82 83 100 100 80
Charmander Fire null 39 52 43 60 50 65
Charmeleon Fire null 58 64 58 80 65 80
Charizard Fire Flying 78 84 78 109 85 100
Squirtle Water null 44 48 65 50 64 43
Wartortle Water null 59 63 80 65 80 58
Blastoise Water null 79 83 100 85 105 78
Caterpie Bug null 45 30 35 20 20 45
Metapod Bug null 50 20 55 25 25 30
Butterfree Bug Flying 60 45 50 90 80 70
Weedle Bug Poison 40 35 30 20 20 50
Kakuna Bug Poison 45 25 50 25 25 35
Beedrill Bug Poison 65 90 40 45 80 75
Pidgey Flying Normal 40 45 40 35 35 56
     */

    

    // Question 5: Read and Filter Pokémon Stats Data by Type
    public static String[] readFilterPokeType(String filename, String poketype) {
        File file = new File(filename);
        String[] result = null;
        int index = 0;
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] tokens = line.split("\\s+");
                String type1 = tokens[1];
                String type2 = tokens[2];
                if (type1.equalsIgnoreCase(poketype) || (type2 != null && type2.equalsIgnoreCase(poketype))) {
                }
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return result;
    }    
        /*
         * Write a method that reads pokemon data from a file and filters
         *  the pokémons with the specified type and returns the names
         *  of the pokémons with specified types as String Array
         * Example: For the data above, poketype="Flying": the output 
         *  should be ["Charizard", "Butterfree", "Pidgey"]
         * Exception handling message should take only one line in console.
         * 
         * Args:
         *      filename: String that specifies the target data file.
         *      poketype: String that represents the target Pokémon type.
         *          (Do not print a message for non-existant Pokémon types
         *          just return an empty string array in that case.)
         * 
         * Returns:
         *      String[]: String that contains the Pokémon names of the specified type.
         * 
         */
        /*
     * Example Pokémon Data:
Name Type1 Type2 HP Attack Defense Sp.Atk Sp.Def Speed
Bulbasaur Grass Poison 45 49 49 65 65 45
Ivysaur Grass Poison 60 62 63 80 80 60
Venusaur Grass Poison 80 82 83 100 100 80
Charmander Fire null 39 52 43 60 50 65
Charmeleon Fire null 58 64 58 80 65 80
Charizard Fire Flying 78 84 78 109 85 100
Squirtle Water null 44 48 65 50 64 43
Wartortle Water null 59 63 80 65 80 58
Blastoise Water null 79 83 100 85 105 78
Caterpie Bug null 45 30 35 20 20 45
Metapod Bug null 50 20 55 25 25 30
Butterfree Bug Flying 60 45 50 90 80 70
Weedle Bug Poison 40 35 30 20 20 50
Kakuna Bug Poison 45 25 50 25 25 35
Beedrill Bug Poison 65 90 40 45 80 75
Pidgey Flying Normal 40 45 40 35 35 56
     */

    // Question 6: Read and Filter Pokémon Stats Data by Highest Speed Stat
    public static void readFilterPokeStats(String filename) {
        File file = new File(filename);
        try (Scanner reader = new Scanner(file)) {





        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        
    	
    }
        /*
         * Write a method that reads pokemon data from a file and filters
         *  and prints the 5 pokémons with the highest Speed stat along
         *  with the data header to the console.
         * Print them with their stats without sorting.
         * Exception handling message should take only one line in console.
         * 
         * Args:
         *      filename: String that specifies the target data file.
         * 
         */
        /*
     * Example Pokémon Data:
Name Type1 Type2 HP Attack Defense Sp.Atk Sp.Def Speed
Bulbasaur Grass Poison 45 49 49 65 65 45
Ivysaur Grass Poison 60 62 63 80 80 60
Venusaur Grass Poison 80 82 83 100 100 80
Charmander Fire null 39 52 43 60 50 65
Charmeleon Fire null 58 64 58 80 65 80
Charizard Fire Flying 78 84 78 109 85 100
Squirtle Water null 44 48 65 50 64 43
Wartortle Water null 59 63 80 65 80 58
Blastoise Water null 79 83 100 85 105 78
Caterpie Bug null 45 30 35 20 20 45
Metapod Bug null 50 20 55 25 25 30
Butterfree Bug Flying 60 45 50 90 80 70
Weedle Bug Poison 40 35 30 20 20 50
Kakuna Bug Poison 45 25 50 25 25 35
Beedrill Bug Poison 65 90 40 45 80 75
Pidgey Flying Normal 40 45 40 35 35 56
     */
    

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