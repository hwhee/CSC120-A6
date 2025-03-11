public class Passenger implements PassengerRequirements{
    
    private String name;

    /**
     * Constructor for Passenger class
     * @param name Passenger's name
     */
    public Passenger(String name) {
        this.name = name;
    }

    //methods:

    /**
     * calls addPassenger from the Car class to add passenger, prints error message if fails
     * @param c
     */
    public void boardCar(Car c){
        boolean addSuccess = c.addPassenger(this);
        if( ! addSuccess){
            System.out.println("Error: this car is full or passenger was already onboard this car.");
        }
    }

    /**
     * calls removePassenger from the Car class to remove passenger, prints error message if fails
     * @param c
     */
    public void getOffCar(Car c){
        boolean removeSuccess = c.removePassenger(this);
        if (! removeSuccess);
            System.out.println("Error: passenger was not onboard this car.");
    }

    /**
     * toString used to format the manifest
     */
    public String toString(){
        return this.name;
    }
}
