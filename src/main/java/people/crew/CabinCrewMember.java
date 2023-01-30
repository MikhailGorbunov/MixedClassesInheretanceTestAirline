package people.crew;

public class CabinCrewMember extends CrewMember{

    public CabinCrewMember(String name, CrewRank rank) {
        super(name, rank);
    }

    public String makeAnnouncement(String message){
        return "Attention please: " + message;
    }


}