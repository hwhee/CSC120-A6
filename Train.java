import java.util.ArrayList;

public class Train implements TrainRequirements{
    
    //attributes
    private Engine engine;
    private ArrayList <Car> cars;
    private int [] carCheck;

    /**
     * Constructor for Train class
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, fuelCapacity, fuelCapacity);
        this.cars = new ArrayList<>();
        for (int i = 0; i < nCars; i++){
            Car car = new Car(passengerCapacity);
            cars.add(car);
        }
    }

    //accessors

    /**
     * Accessor for engine
     */
    public Engine getEngine(){
        return this.engine;
    }

    /**
     * Accessor for car
     */
    public Car getCar(int i){
        return this.cars.get(i);
    }

    /**
     * Accessor for car array size added for unit testing
     */
    public int trainLength(){
        return this.cars.size();
    }

    /**
     * Accessor for max capacity
     */
    public int getMaxCapacity(){
        int maxCapacity = 0;
        for (int i = 0; i<cars.size();i++){
            maxCapacity = maxCapacity + cars.get(i).getCapacity();
        }
        return maxCapacity;
    }

    /**
     * Accessor for seats remaining
     */
    public int seatsRemaining(){
        int openSeats = 0;
        for (int i = 0; i<cars.size();i++){
            openSeats = openSeats + cars.get(i).seatsRemaining();
        }
        return openSeats;
    }

    /**
     * Accessor for carCheck (for printManifest unit test)
     */
    public int[] getCarCheck(){
        return carCheck;
    }

    //methods

    /**
     * prints manifests from each car. Added carCheck variable to check that method iterates through each car's manifest. 
     */
    public void printManifest(){
        carCheck = new int[cars.size()];
        for (int i = 0; i<cars.size();i++){
            cars.get(i).printManifest();
            System.out.println("\n");
            carCheck[i]= i;
        }
    }

    public static void main(String[] args) {

        Train myTrain = new Train(FuelType.ELECTRIC, 100, 3, 5);
        myTrain.printManifest();

     }
}
