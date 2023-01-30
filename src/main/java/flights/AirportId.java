
package flights;

public enum AirportId {

    GLASGOW("GLA"),
    EDINBURGH("EDI");


    private final String name;

    AirportId(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}