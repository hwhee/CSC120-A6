import static org.junit.Assert.*;
import org.junit.Test;

public class TrainTest {

    // Engine Tests
    @Test
    public void testEngineConstructor() {
        Engine e = new Engine(FuelType.ELECTRIC, 100, 100);
        assert e.getFuelType() == FuelType.ELECTRIC;
        assert e.getCurrentFuel() == 100;
    }

    @Test
    public void testEngineGo() {
        Engine e = new Engine(FuelType.ELECTRIC, 5, 100);
        assertFalse (e.go());
        assert e.getCurrentFuel() == 5;
        Engine en = new Engine(FuelType.ELECTRIC, 10, 100);
        assertFalse (en.go());
        assert en.getCurrentFuel() == 10;
        Engine eng = new Engine(FuelType.ELECTRIC, 100, 100);
        assertTrue (eng.go());
        assert eng.getCurrentFuel() == 90;
    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        Passenger p = new Passenger("john");
        Car c = new Car (1);
        c.addPassenger(p);
        assert c.seatsRemaining()==0;
    }

    @Test
    public void testCarRemovePassenger() {
        Passenger p = new Passenger("john");
        Car c = new Car (1);
        assertFalse (c.removePassenger(p));
        assert c.seatsRemaining() == 1;
        c.addPassenger(p);
        assert c.seatsRemaining()==0;
        assertTrue (c.removePassenger(p));
        assert c.seatsRemaining()==1;
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        Passenger p = new Passenger("john");
        Car c = new Car (1);
        assertFalse (c.isOnboard(p));
        c.addPassenger(p);
        assertTrue (c.isOnboard(p));
    }

    @Test
    public void testPassengerBoardCarFull() {
        Passenger p = new Passenger("john");
        Car c = new Car (0);
        assertFalse (c.isOnboard(p));
        c.addPassenger(p);
        assertFalse (c.isOnboard(p));
        assert c.seatsRemaining()==0;
    }

    // Train Tests
    @Test
    public void testTrainConstructor() {
        Train t = new Train(FuelType.ELECTRIC, 100, 10, 10);
        assert t.trainLength() == 10;
        assert t.getEngine().getFuelType() == FuelType.ELECTRIC;
        assert t.getEngine().getMaxFuel() == 100;
        assert t.getMaxCapacity() == 100;
    }

    @Test
    public void testTrainPassengerCount() {
        Train t = new Train(FuelType.ELECTRIC, 100, 10, 10);
        
        // testing passenger count as passengers board various cars
        Passenger p = new Passenger("john");
        Car c = t.getCar(3);
        c.addPassenger(p);
        assert t.seatsRemaining()==99;
        Passenger pa = new Passenger("doe");
        Car ca = t.getCar(4);
        ca.addPassenger(pa);
        assert t.seatsRemaining()==98;
        Passenger pas = new Passenger("jane");
        Car car = t.getCar(7);
        car.addPassenger(pas);
        assert t.seatsRemaining()==97;
        
        // testing passenger count as passengers leave various cars
        c.removePassenger(p);
        assert t.seatsRemaining()==98;
        ca.removePassenger(pa);
        assert t.seatsRemaining()==99;
        car.removePassenger(pas);
        assert t.seatsRemaining()==100;
    }

    @Test
    public void testTrainGetCar() {
        Train t = new Train(FuelType.ELECTRIC, 100, 3, 10);
        Car c = t.getCar(0);
        Car ca = t.getCar(1);
        Car car = t.getCar(2);
        assertFalse (c==ca);
        assertFalse (c==car);
        assertFalse (ca==car);
        assertTrue (c==t.getCar(0));
        assertTrue (ca==t.getCar(1));
        assertTrue (car==t.getCar(2));
        
    }

    @Test
    public void testTrainPrintManifest() {
        Train t = new Train(FuelType.ELECTRIC, 100, 3, 10);
        t.printManifest();
        int[] expectedResult = {0,1,2};
        assertEquals(expectedResult.length, t.getCarCheck().length);
        for (int i = 0; i < expectedResult.length; i++){
            assertEquals(expectedResult[i], t.getCarCheck()[i]);
        }
    }
    
}
