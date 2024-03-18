/**
* This class will represent a basic model of a Car, with brand, year manufacture, 
* and price as param, and allow to gain access to them.
* Will also implement comparable Car
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author God Miles Anro Ruiz
* @since  03/17/2024
*
*/
class Car implements Comparable<Car> {
    private String make;
    private int year;
    private int price;
    
    /**
	* Constructor to initialize 'Car' object with the specified make, year, and price
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author God Miles Anro Ruiz
	* @since  03/17/2024
	*
	*/
    public Car(String make, int year, int price) {
        this.make = make;	//sets the make of the car
        this.year = year;	//sets the year of the car
        this.price = price;	//sets the price of the car
    }

    /**
	* Returns the brand of the car
	*
	* CSC 1351 1
	* Section 2
	*
	* @author God Miles Anro Ruiz
	* @since  03/17/2024
	*
	*/
    public String getMake() {
        return make;
    }

    /**
	* Returns the year it was made
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author God Miles Anro Ruiz
	* @since  03/17/2024
	*
	*/
    public int getYear() {
        return year;
    }

    /**
	* Returns the price of the Car
	*
	* CSC 1351 Programming Project No enter project number here
	* Section 2
	*
	* @author God Miles Anro Ruiz
	* @since  03/17/2024
	*
	*/
    public int getPrice() {
        return price;
    }
    
    /**
	* Compares two Car based on make and year
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author God Miles Anro Ruiz
	* @since  03/17/2024
	*
	*/
    public int compareTo(Car other) {
        if (make.compareTo(other.make) !=0) { //Compare make attributes of the cars
        	return make.compareTo(other.make);
    	} else {	
        return Integer.compare(year, other.year);
    	}
    }
    /**
	* Returns a String representing the Car
	*
	* CSC 1351 Programming Project No 1
	* Section 2
	*
	* @author God Miles Anro Ruiz
	* @since  03/17/2024
	*
	*/
    public String toString() {
        return "Make: " + make + ", Year: " + year + ", Price: " + price + ";";
    }
}
