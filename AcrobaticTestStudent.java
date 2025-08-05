import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AcrobaticTestStudent {
	 @Test
	    public void testConstructorAndGetters() {
	        Acrobatic acrobat = new Acrobatic("Luna", 24, 3, "Trapeze Artist");

	        assertEquals("Luna", acrobat.getName());
	        assertEquals(24, acrobat.getAge());
	        assertEquals(3, acrobat.getYearsWorked());
	        assertEquals("Trapeze Artist", acrobat.getJob());
	    }

	    @Test
	    public void testToString() {
	        Acrobatic acrobat = new Acrobatic("Max", 30, 5, "Juggler");
	        String expected = "Acrobatic [Name: Max, Age: 30, Years Worked: 5, Job: Juggler]";
	        assertEquals(expected, acrobat.toString());
	    }

	    @Test
	    public void testEqualsTrue() {
	        Acrobatic a1 = new Acrobatic("Nina", 22, 2, "Tightrope Walker");
	        Acrobatic a2 = new Acrobatic("Nina", 22, 2, "Tightrope Walker");
	        assertTrue(a1.equals(a2));
	    }

	    @Test
	    public void testEqualsFalse() {
	        Acrobatic a1 = new Acrobatic("Nina", 22, 2, "Tightrope Walker");
	        Acrobatic a2 = new Acrobatic("Leo", 22, 2, "Tightrope Walker");
	        assertFalse(a1.equals(a2));
	    }

	    @Test
	    public void testClone() {
	        Acrobatic original = new Acrobatic("Kai", 27, 6, "Fire Dancer");
	        Acrobatic copy = original.clone();

	        assertEquals(original, copy);
	        assertNotSame(original, copy); // Ensure it's a separate object
	    }
}
