package flights;

import people.passenger.Passenger;

import javax.xml.crypto.Data;

public class FlightManager {

    Flight flight;
    int flightData;

    public FlightManager(Flight flight) {
        this.flight = flight;
        this.flightData = flight.getPlane().getTotalWeight();
    }

    public int getFlightCargoData() {
        return flightData;
    }

    public Flight getFlight(){
        return this.flight;
    }

    public int getBaggageCapacity(){
        return (this.flightData / 2);
    }

    public int getWeightAllowancePerCustomer(){
        int passengerCount = this.flight.getPassengers();
        System.out.println(passengerCount);
        return (this.getBaggageCapacity() / passengerCount);
    }

    public int getTotalBaggageWeight(){
        int totalItemsOfLuggage = 0;
        for (Passenger passenger : this.flight.getPassengerManifest()){
            totalItemsOfLuggage += passenger.getBags();
        }
        return (totalItemsOfLuggage * this.flight.getWeightPerBag());
    }

    public int getRemainingCargoCapacity(){
        return (this.getBaggageCapacity() - this.getTotalBaggageWeight());
    }
}