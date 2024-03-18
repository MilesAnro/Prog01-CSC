import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
* Main class that manages the processing of list cars. 
* Reads input from a file and write an output in a given format.
*
* CSC 1351 Programming Project No 1
7
* Section 2
*
* @author God Miles Anro Ruiz
* @since 03/17/2024
*
*/
public class Prog01_aOrderedList {
	
        /**
	    * The main method ask the user for the file, it reads the input, process data,
	    * and writes the output by using other methods below.
	    *
	    * CSC 1351 Programming Project No 1
	    * Section 2
	    *
	    * @author God Miles Anro Ruiz
	    * @since 03/17/2024
	    *
	    */
    public static void main(String[] args) {
    	try {
            Scanner fileScanner = GetInputFile("Enter input filename: "); //Ask user for input file
            aOrderedList<Car> orderedList = new aOrderedList<>();
            while (fileScanner.hasNextLine()) { //Process input file
                String line = fileScanner.nextLine();
                String[] tokens = line.split(",");
                
                if ("A".equalsIgnoreCase(tokens[0])) { //Add car to the list
                    Car car = new Car(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                    orderedList.add(car);
                } else if ("D".equalsIgnoreCase(tokens[0]) && tokens.length == 3) { //Deletes car from the list
                    String make = tokens[1];
                    int year = Integer.parseInt(tokens[2]);
                    orderedList.reset();
                    while (orderedList.hasNext()) {
                        Car car = orderedList.next();
                        if (car.getMake().equals(make) && car.getYear() == year) {
                            orderedList.remove();
                            break;
                        }
                    }
                }
            }

            PrintWriter output = GetOutputFile("Enter output filename: "); //Ask user for output file
            OutPutFormat(output, orderedList); //Write output
            output.close();

            System.out.println("Operations completed and output successfully written to file.");
    	} catch (FileNotFoundException e) {
            System.out.println("Program execution cancelled or file not found.");
        }
 
    }

     /**
     * Formats and prints the output of the ordered list of cars.
     * Prints the number of cars, make, year, and price.
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author God Miles Anro Ruiz
     * @since 03/17/2024
     *
     */
    private static void OutPutFormat(PrintWriter output, aOrderedList<Car> orderedList) {
        output.println("Number of cars: " + orderedList.size());
        orderedList.reset();
        
        while (orderedList.hasNext()) {
            Car car = orderedList.next();
            output.println("Make: " + car.getMake());
            output.println("Year: " + car.getYear());
            output.printf("Price: $%,d\n\n", car.getPrice());
        }
    }
    
     /**
     * Retrieves an input file from the user by typing it in the console.
     * Returns a scanner object for reading from file.
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author God Miles Anro Ruiz
     * @since 03/17/2024
     *
     */
    public static Scanner GetInputFile(String userPrompt) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println(userPrompt);
        
        while (true) {
            String fileName = input.nextLine();
            File file = new File(fileName);
            if (file.exists()) {
                return new Scanner(file);
            } else {
                System.out.println("File specified <" + fileName + "> does not exist. Would you like to continue? <Y/N>");
                if (input.nextLine().equalsIgnoreCase("N")) {
                    throw new FileNotFoundException("User cancelled the operation.");
                }
         
                System.out.println("Please enter a valid filename:");
            }
        }
    }

    /**
    * Retrieves an output file from the user by typing the name in the console.
    * Returns PrintWriter for writing the output to the file.
    *
    * CSC 1351 Programming Project No 1
    * Section 2
    *
    * @author God Miles Anro Ruiz
    * @since 03/17/2024
    *
    */
    public static PrintWriter GetOutputFile(String userPrompt) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println(userPrompt);
        
        while (true) {
            String fileName = input.nextLine();
            try {
                return new PrintWriter(fileName);
            } catch (FileNotFoundException e) {
                System.out.println("Unable to write to file specified <" + fileName + ">. Would you like to continue? <Y/N>");
                if (input.nextLine().equalsIgnoreCase("N")) {
                    throw new FileNotFoundException("User cancelled the operation.");
                }
                
                System.out.println("Please enter a valid filename:");
            }
        }
    }
}