	
	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.Test;

	

public class ClerkTestStudent {

	


	    @Test
	    public void testConstructorAndGetters() {
	        Clerk clerk = new Clerk("Alice", 30, 5, "Ticket Clerk");

	        assertEquals("Alice", clerk.getName());
	        assertEquals(30, clerk.getAge());
	        assertEquals(5, clerk.getYearsWorked());
	        assertEquals("Ticket Clerk", clerk.getJob());
	    }

	    @Test
	    public void testToString() {
	        Clerk clerk = new Clerk("Bob", 40, 10, "Sales Clerk");
	        String expected = "Clerk [Name: Bob, Age: 40, Years Worked: 10, Department: Sales Clerk]";
	        assertEquals(expected, clerk.toString());
	    }

	    @Test
	    public void testEqualsTrue() {
	        Clerk c1 = new Clerk("Emma", 25, 3, "Ticket Clerk");
	        Clerk c2 = new Clerk("Emma", 25, 3, "Ticket Clerk");
	        assertTrue(c1.equals(c2));
	    }

	    @Test
	    public void testEqualsFalse() {
	        Clerk c1 = new Clerk("Emma", 25, 3, "Ticket Clerk");
	        Clerk c2 = new Clerk("Emma", 25, 3, "Front Desk");
	        assertFalse(c1.equals(c2));
	    }

	    @Test
	    public void testClone() {
	        Clerk original = new Clerk("Zoe", 28, 4, "Front Desk");
	        Clerk copy = original.clone();

	        assertEquals(original, copy);
	        assertNotSame(original, copy); // Confirm they are different objects
	    }
	

}
