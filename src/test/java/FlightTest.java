

import flights.AirportId;
import flights.Flight;
import flights.plane.Plane;
import flights.plane.PlaneType;
import org.junit.Before;
import org.junit.Test;
import people.crew.CabinCrewMember;
import people.crew.CrewRank;
import people.crew.Pilot;
import people.passenger.Passenger;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FlightTest {

    Flight flight;
    Plane plane;
    Pilot pilot;
    CabinCrewMember cabinCrew;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;

    @Before
    public void before(){
        passenger1 = new Passenger("Misha", 3);
        passenger2 = new Passenger("Alex", 2);
        passenger3 = new Passenger("Tim", 1);
        cabinCrew = new CabinCrewMember("Tom", CrewRank.LEADATTENDANT);
        pilot = new Pilot("Kate", CrewRank.CAPTAIN, "12345");
        plane = new Plane(PlaneType.Cessna);
        flight = new Flight(plane, "123", AirportId.EDINBURGH, AirportId.GLASGOW);
    }

    @Test
    public void pilotBeginsEmpty() {
        assertEquals(0, flight.getPilots());
    }

    @Test
    public void canAddPilot() {
        flight.addPilot(pilot);
        assertEquals(1, flight.getPilots());
    }

    @Test
    public void crewBeginsEmpty() {
        assertEquals(0, flight.getCrew());
    }

    @Test
    public void canAddCrew() {
        flight.addCabinCrew(cabinCrew);
        assertEquals(1, flight.getCrew());
    }

    @Test
    public void passengersBeginsEmpty() {
        assertEquals(0, flight.getPassengers());
    }

    @Test
    public void canAddPassengers() {
        flight.addPassenger(passenger1);
        assertEquals(1, flight.getPassengers());
    }

    @Test
    public void cannotAddPassengers() {
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        flight.addPassenger(passenger3);
        assertEquals(2, flight.getPassengers());
    }

    @Test
    public void canGetPlane() {
        Plane planeInfo = flight.getPlane();
        assertEquals("Cessna", planeInfo.getType().toString());
    }

    @Test
    public void canGetFlightNumber() {
        assertEquals("123", flight.getFlightNumber());
    }

    @Test
    public void canSetFLightNumber() {
        flight.setFlightNumber("456");
        assertEquals("456", flight.getFlightNumber());
    }

    @Test
    public void canGetDestination() {
        assertEquals("EDI", flight.getArrivalAirport());
    }

    @Test
    public void canGetDepartureAirport() {
        assertEquals("GLA", flight.getDepartureAirport());
    }

//    @Test
//    public void canGetDepartureTime() {
//        assertEquals("2021-02-15T10:15", flight.getDepartureTime().toString());
//    }

//    @Test
//    public void canSetDepartureTime() {
//        flight.setDepartureTime("2022/02/15 10:15");
//        assertEquals("2022-02-15T10:15", flight.getDepartureTime().toString());
//    }

    @Test
    public void canGetWeightPerBag(){
        assertEquals(10, flight.getWeightPerBag());
    }

    @Test
    public void canReturnRemainingSeats() {
        flight.addPassenger(passenger1);
        assertEquals(1, flight.remainingSeats());
    }

    @Test
    public void checkPassengerForAssignedFlight(){
        flight.addPassenger(passenger1);
        ArrayList<Passenger> passengerList = flight.getPassengerManifest();
        assertEquals("123", passengerList.get(0).getFlightNumber());
    }

    @Test
    public void checkPassengerForAssignedSeat(){
        flight.addPassenger(passenger1);
        ArrayList<Passenger> passengerList = flight.getPassengerManifest();
        assertNotEquals(0, passengerList.get(0).getSeatNumber());
    }

    @Test
    public void checkPassengerSeatIsUnique(){
        flight.addPassenger(passenger1);
        ArrayList<Passenger> passengerList = flight.getPassengerManifest();
        int seatNumber = passengerList.get(0).getSeatNumber();
        assertEquals(true, flight.seatCheck(seatNumber));
    }

}