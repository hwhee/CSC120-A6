import java.util.ArrayList;

public class Car implements CarRequirements{
    
    //attributes
    private ArrayList <Passenger> passengersOnboard;
    private int maxCapacity;

    /**
     * Constructor for Car
     * @param maxCapacity integer representing the maximum capacity for the car
     */
    public Car(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.passengersOnboard = new ArrayList<>();
    }


    /**
     * Accessor to get capacity
     */
    public int getCapacity(){
        return this.maxCapacity;
    }

    /**
     * Accessor-like method to get seats remaining that subtracts the amount of passengers currently onboard from the maximum capacity
     * @return returns the seats remaining
     */
    public int seatsRemaining(){
        return (this.maxCapacity - this.passengersOnboard.size());
    }

    public boolean isOnboard(Passenger p){
        return this.passenger.contains(p);
    }

    //methods:

    /**
     * Checks if car is full and if passenger is already onboard. If yes, returns false, if no, adds passenger to car.
     * @param p passenger information
     * @return boolean based on if the passenger can board the car or not
     */
    public Boolean addPassenger(Passenger p){
        if (passengersOnboard.size()<maxCapacity){
            if (passengersOnboard.contains(p)){
                return false;
            } else {
                passengersOnboard.add(p);
                return true;
            }
        } else{
            return false;
        }
        
    }

    /**
     * Checks if the passenger is actually on board, if yes returns true, if no, returns false
     * @param p passenger information
     * @return boolean based on whether the passenger can de-board or not
     */
    public Boolean removePassenger(Passenger p){
        if (passengersOnboard.contains(p)){
            passengersOnboard.remove(p);
            return true;
        } else {
            return false;
        }

    }

    /**
     * prints manifest of the car unless the car is empty
     */
    public void printManifest(){
        if (passengersOnboard.size() == 0){
            System.out.println("This car is EMPTY.");
        } else {
            String manifest = "";
            for (int i = 0; i<passengersOnboard.size(); i++){
                manifest = manifest + (i+1) + ". " + passengersOnboard.get(i) +"\n";
            }
            System.out.println(manifest + "\n");
        }
        
        }

    public static void main(String[] args) {

            Car myCar = new Car(15);
            Passenger hanna = new Passenger("Hanna");
            myCar.addPassenger(hanna);
            myCar.printManifest();
            Passenger yaya = new Passenger("Yaya");
            myCar.addPassenger(yaya);
            myCar.printManifest();
            myCar.removePassenger(yaya);
            myCar.printManifest();

         }
    }