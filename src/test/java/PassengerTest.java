import org.junit.Before;
import org.junit.Test;
import people.passenger.Passenger;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;

    @Before
    public void before(){
        passenger = new Passenger("Misha", 2);
    }

    @Test
    public void canGetName(){
        assertEquals("Misha", passenger.getName());
    }

    @Test
    public void canSetName(){
        passenger.setName("Mikhail");
        assertEquals("Mikhail", passenger.getName());
    }

    @Test
    public void canGetNumberOfBags(){
        assertEquals(2, passenger.getBags());
    }

    @Test
    public void canSetNumberOfBags(){
        passenger.setBags(3);
        assertEquals(3, passenger.getBags());
    }

    @Test
    public void flightNumberBeginsEmpty(){
        assertEquals(null, passenger.getFlightNumber());
    }

    @Test
    public void canSetFlightNumber(){
        passenger.setFlightNumber("123");
        assertEquals("123", passenger.getFlightNumber());
    }

    @Test
    public void seatNumberBeginsAtZero(){
        assertEquals(0, passenger.getSeatNumber());
    }

    @Test
    public void canSetSeatNumber(){
        passenger.setSeatNumber(1);
        assertEquals(1, passenger.getSeatNumber());
    }
}