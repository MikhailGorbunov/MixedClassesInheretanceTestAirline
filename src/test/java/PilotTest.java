import org.junit.Before;
import org.junit.Test;
import people.crew.CrewRank;
import people.crew.Pilot;

import static org.junit.Assert.assertEquals;

public class PilotTest {

    Pilot pilot;

    @Before
    public void before(){
        pilot  = new Pilot("Mikhail Gorbunov", CrewRank.CAPTAIN, "Misha");
    }

    @Test
    public void canGetLicenseNumber(){
        assertEquals("Misha", pilot.getLicenseNumber());
    }

    @Test
    public void canFly(){
        assertEquals("Our aircraft is about 3000m above sea level", pilot.flyMethod());
    }

}