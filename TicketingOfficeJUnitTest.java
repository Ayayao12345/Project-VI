import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;

public class TicketingOfficeJUnitTest {
	

	
	    private TicketingOffice office;

	    @BeforeEach
		//setUp()
	    void setUp() {
	        office = new TicketingOffice("Red", 10.0, 15.0);
	    }

	    @Test
		//testConstructor()
	    void testConstructor() {
	        assertEquals("Red", office.getColor());
	        assertEquals(10.0, office.getLength());
	        assertEquals(15.0, office.getWidth());
	        assertEquals("Ticketing Office", office.getBuildingType());
	    }
		
	    @Test
		//testSetSize()
	    void testSetSize() {
	        office.setSize(20.0, 25.0);
	        assertEquals(20.0, office.getLength());
	        assertEquals(25.0, office.getWidth());
	    }

		@Test
		//testSetColor()
		void testSetColor() {
	        office.setColor("Blue");
	        assertEquals("Blue", office.getColor());
	    }


	    @Test
		//testSetBuildingType()

	    void testSetBuildingType() {
	        office.setBuildingType("Booth");
	        assertEquals("Booth", office.getBuildingType());
	    }
	    
	    
	    
	    
	    @Test
		//testToString()	
	    void testToString () {
	    String result = office.toString();
        assertTrue(result.contains("Ticketing Office"));
        assertTrue(result.contains("Color=Red"));
        assertTrue(result.contains("Length=10.00"));
        assertTrue(result.contains("Width=15.00"));
    }





}
