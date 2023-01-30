import flights.AirportId;
import flights.Flight;
import flights.FlightManager;
import flights.plane.Plane;
import flights.plane.PlaneType;
import org.junit.Before;
import org.junit.Test;
import people.passenger.Passenger;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    FlightManager flightManager;
    Flight flight;
    Passenger passenger1;
    Passenger passenger2;

    @Before
    public void before(){
        passenger1 = new Passenger("Mr Gorbunov", 5);
        passenger2 = new Passenger("Mr Gorbunova", 1);
        Plane plane = new Plane(PlaneType.BOEING747);
        flight = new Flight(plane,  "123", AirportId.GLASGOW, AirportId.EDINBURGH );
        flightManager = new FlightManager(flight);
    }

    @Test
    public void canGetFlightCargoData(){
        assertEquals(1000, flightManager.getFlightCargoData());
    }

    @Test
    public void canGetFlight(){
        Flight currentFlight = flightManager.getFlight();
        assertEquals("123", currentFlight.getFlightNumber());
    }

    @Test
    public void canGetBaggageCapacity(){
        assertEquals(500, flightManager.getBaggageCapacity());
    }

    @Test
    public void canGetWeightAllowancePerCustomer(){
        Flight currentFlight = flightManager.getFlight();
        currentFlight.addPassenger(passenger1);
        currentFlight.addPassenger(passenger2);
        assertEquals(250, flightManager.getWeightAllowancePerCustomer());
    }

    @Test
    public void canGetTotalBaggageWeight(){
        Flight currentFlight = flightManager.getFlight();
        currentFlight.addPassenger(passenger1);
        currentFlight.addPassenger(passenger2);
        assertEquals(60, flightManager.getTotalBaggageWeight());
    }

    @Test
    public void canGetRemainingCargoCapacity(){
        Flight currentFlight = flightManager.getFlight();
        currentFlight.addPassenger(passenger1);
        currentFlight.addPassenger(passenger2);
        assertEquals(440, flightManager.getRemainingCargoCapacity());
    }
}