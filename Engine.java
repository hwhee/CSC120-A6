public class Engine implements EngineRequirements{
    
    //attributes
    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel;


    /**
     * Constructor for Engine
     * @param f Engine's fuel type
     * @param currentFuelLevel Engine's current fuel level
     * @param maxFuelLevel Engine's max fuel level
     */
    public Engine(FuelType f, double currentFuelLevel, double maxFuelLevel){
        this.f = f;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

     //methods

     /**
      * Accessor to get fuel type
      */
     public FuelType getFuelType(){
        return this.f;
     }

     /**
      * Accessor to get maximum fuel level
      */
     public double getMaxFuel(){
        return this.maxFuelLevel;
     }

     /**
      * Accessor to get current fuel level
      */
     public double getCurrentFuel(){
        return this.currentFuelLevel;
     }

     /**
      * Refuels by setting current fuel level to the maximum
      */
     public void refuel(){
        this.currentFuelLevel = this.maxFuelLevel;
     }

     /**
      * Determines whether there is enough fuel in the tank. If there is, subtracts 10. fuel, prints current fuel level and returns true if the current fuel level is above 0, false if not, if the fuel level is insufficient, prints error message and returns false
      * @return boolean true if the engine has enough fuel, false if not
      */
     public Boolean go(){
        if (this.currentFuelLevel>10.){
            this.currentFuelLevel = this.currentFuelLevel-10.;
            System.out.println("Current fuel level is:" + this.currentFuelLevel);
            if (this.currentFuelLevel>0){
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("Error: insufficient fuel level");
            return false;
        }
     }

     public String toString(){
        return("Engine has fuel type: " + this.f + "; current fuel level: " + this.currentFuelLevel + "; and max fuel level: " + this.maxFuelLevel);
     }

     public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 0., 100.);
        System.out.println(myEngine);
        myEngine.go();
        System.out.println(myEngine);
        myEngine.refuel();
        System.out.println(myEngine);
        myEngine.go();
        System.out.println(myEngine);

     }

}