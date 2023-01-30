import org.junit.Before;
import org.junit.Test;
import people.crew.CabinCrewMember;
import people.crew.CrewRank;

import static org.junit.Assert.assertEquals;

public class CabinCrewMemberTest {

    CabinCrewMember cabinCrewMember;

    @Before
    public void before(){
        cabinCrewMember = new CabinCrewMember("Misha", CrewRank.CAPTAIN);
    }

    @Test
    public void canReturnName(){
        assertEquals("Misha", cabinCrewMember.getName());
    }

    @Test
    public void canSetName(){
        cabinCrewMember.setName("Mikhail");
        assertEquals("Mikhail", cabinCrewMember.getName());
    }

    @Test
    public void canGetRank(){
        assertEquals("Captain", cabinCrewMember.getRank());
    }

    @Test
    public void canGiveAnnouncement(){
        String announcement = cabinCrewMember.makeAnnouncement("My name is Misha");
        assertEquals("Attention please: My name is Misha", announcement);
    }


}