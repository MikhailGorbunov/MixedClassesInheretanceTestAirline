import flights.plane.Plane;
import flights.plane.PlaneType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;

    @Before
    public void before(){
        plane = new Plane(PlaneType.BOEING747);
    }

    @Test
    public void canGetCapacity() {
        assertEquals(524, plane.getPlaneCapacity());
    }

    @Test
    public void canGetTotalWeight() {
        assertEquals(1000, plane.getTotalWeight());
    }
}