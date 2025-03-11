import static org.junit.Assert.*;
import org.junit.Test;

public class TrainTest {

    // Engine Tests
    @Test
    public void testEngineConstructor() {
        fail();
    }

    @Test
    public void testEngineGo() {
        fail();
    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        Passenger p = new Passenger("john");
        Car c = new Car (1);
        assert False (c.isOnboard(p));
        c.addPassenger(p);
        assert True (c.isOnboard(p));
        assert True (c.seatsRemaining==0);
    }

    @Test
    public void testCarRemovePassenger() {
        fail();
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        fail();
    }

    @Test
    public void testPassengerBoardCarFull() {
        Passenger p = new Passenger("john");
        Car c = new Car (0);
        assert False (c.isOnboard(p));
        c.addPassenger(p);
        assert False (c.isOnboard(p));
        assert True (c.seatsRemaining==0);
    }

    // Train Tests
    @Test
    public void testTrainConstructor() {
        fail();
    }

    @Test
    public void testTrainPassengerCount() {
        fail();
    }

    @Test
    public void testTrainGetCar() {
        fail();
    }

    @Test
    public void testTrainPrintManifest() {
        fail();
    }
    
}
