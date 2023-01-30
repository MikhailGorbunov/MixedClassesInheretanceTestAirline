package flights;

import flights.plane.Plane;
import people.crew.CabinCrewMember;
import people.crew.Pilot;
import people.passenger.Passenger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Flight {
    private ArrayList<Pilot> pilots;
    private ArrayList<CabinCrewMember> crew;
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private AirportId arrivalAirport;
    private AirportId departureAirport;
//    private LocalDateTime departureTime;
    private int weightPerBag;

    public Flight(Plane plane, String flightNumber, AirportId arrivalAirport, AirportId departureAirport) {
        this.pilots = new ArrayList<Pilot>();
        this.crew = new ArrayList<CabinCrewMember>();
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
//        this.departureTime = departureTime;
        this.weightPerBag = 10;
    }

    public int getPilots() {
        return pilots.size();
    }

    public int getCrew() {
        return crew.size();
    }

    public int getPassengers() {
        return passengers.size();
    }

    public Plane getPlane() {
        return plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getArrivalAirport() {
        return arrivalAirport.getName();
    }

    public String getDepartureAirport() {
        return departureAirport.getName();
    }

//    public LocalDateTime getDepartureTime() {
//        return departureTime;
//    }

    public int getWeightPerBag() {
        return this.weightPerBag;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

//    public void setDepartureTime(LocalDateTime departureTime) {
//        this.departureTime = departureTime;
//    }

    public void setPassengerFlightNumber(Passenger passenger, String flightNumberToSet){
        passenger.setFlightNumber(flightNumberToSet);
    }

    public int remainingSeats(){
        return (this.plane.getPlaneCapacity() - this.getPassengers());
    }

    public void addPilot(Pilot pilot){
        this.pilots.add(pilot);
    }

    public void addCabinCrew(CabinCrewMember cabinCrew){
        this.crew.add(cabinCrew);
    }

    public boolean seatCheck(int generatedSeat){
        ArrayList<Integer> seatsTaken = new ArrayList<Integer>();

        for(Passenger passenger: this.passengers){
            seatsTaken.add(passenger.getSeatNumber());
        }

        return seatsTaken.contains(generatedSeat);
    }
    public int generateRandomSeat(){
        Random random = new Random();
        return random.nextInt(this.plane.getPlaneCapacity() + 1);
    }
    public void assignPassengerSeat(Passenger passenger){
        int passengerSeat = generateRandomSeat();

        while(this.seatCheck(passengerSeat)){
            passengerSeat = generateRandomSeat();
        }

        passenger.setSeatNumber(passengerSeat);
    }

    public void addPassenger(Passenger passenger){
        if (this.plane.getPlaneCapacity() > this.getPassengers()){
            setPassengerFlightNumber(passenger, this.flightNumber);
            assignPassengerSeat(passenger);
            this.passengers.add(passenger);
        }
    }

    public ArrayList<Passenger> getPassengerManifest(){
        return this.passengers;
    }
}
