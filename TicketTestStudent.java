import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TicketTestStudent {
	
	

	    @Test
	    public void testChildWeekdayLowerLevel() {
	        Ticket ticket = new Ticket("monday", 20.0, 10, "lower", 2); // child, weekday
	        assertEquals(32.4, ticket.calculatePrice(), 0.01);
	    }

	    @Test
	    public void testAdultWeekendTLevel() {
	        Ticket ticket = new Ticket("sunday", 20.0, 35, "t-level", 1); // adult, no discount, t-level = double
	        assertEquals(40.0, ticket.calculatePrice(), 0.01);
	    }

	    @Test
	    public void testSeniorUpperWeekday() {
	        Ticket ticket = new Ticket("wednesday", 20.0, 70, "upper", 1); // senior
	        assertEquals(16.245, ticket.calculatePrice(), 0.01); // 10% weekday, 5% senior, 5% upper
	    }

	    @Test
	    public void testStudentWeekendLower() {
	        Ticket ticket = new Ticket("saturday", 20.0, 19, "lower", 3); // student, no weekday discount
	        assertEquals(54.0, ticket.calculatePrice(), 0.01); // 10% student only
	    }

	    @Test
	    public void testToStringFormat() {
	        Ticket ticket = new Ticket("monday", 20.0, 15, "lower", 2);
	        String output = ticket.toString();
	        assertTrue(output.contains("Day: Monday"));
	        assertTrue(output.contains("Age: 15"));
	        assertTrue(output.contains("Price: $"));
	    
	}

	

}
