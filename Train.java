import java.util.ArrayList;

public class Train implements TrainRequirements{
    
    //attributes
    private Engine engine;
    private ArrayList <Car> cars;

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

    //methods

    /**
     * prints manifests from each car
     */
    public void printManifest(){
        for (int i = 0; i<cars.size();i++){
            cars.get(i).printManifest();
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {

        Train myTrain = new Train(FuelType.ELECTRIC, 100, 3, 5);
        myTrain.printManifest();

     }
}
