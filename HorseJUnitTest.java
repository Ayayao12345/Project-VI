	import static org.junit.jupiter.api.Assertions.*;

	import java.io.ByteArrayOutputStream;
	import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	
public class HorseJUnitTest {
	

	    private Horse horse;
	    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    private 	final PrintStream originalOut = System.out;

	    @BeforeEach
		//setUp()
	    void setUp() {
	        horse = new Horse("Thunder", 7, "Mustang", "Black");
	        System.setOut(new PrintStream(outputStream)); // Redirect System.out
	    }
	    @AfterEach
	    void tearDown() {
	        System.setOut(originalOut); // Restore original System.out
	        outputStream.reset();
	    }
		@Test
		//testMove()
		 void testMove() {
	        horse.move();
	        String output = outputStream.toString().trim();
	        assertTrue(output.toLowerCase().contains("gallop") || output.toLowerCase().contains("move"));
	    }
	    @Test
		//testMakeSound()
	    void testMakeSound() {
	        horse.makeSound();
	        String output = outputStream.toString().trim();
	        assertTrue(output.toLowerCase().contains("neigh"));
	    }

	    @Test
		//testGetName()
	    void testGetName() {
	        assertEquals("Thunder", horse.getName());
	    }


	    @Test
		//testGetAge()
	    void testGetAge() {
	        assertEquals(7, horse.getAge());
	    }
	    @Test
		//testEquals()
	    void testEquals() {
	        Horse sameHorse = new Horse("Thunder", 7, "Mustang", "Black");
	        Horse differentHorse = new Horse("Blaze", 4, "Arabian", "White");
	        assertEquals(horse, sameHorse);
	        assertNotEquals(horse, differentHorse);
	    }
	    @Test
	    void testClone() {
	        Horse cloned = horse.clone();
	        assertEquals(horse, cloned);         // Same content
	        assertNotSame(horse, cloned);        // But different objects
	    }

	    @Test
		//testToString()
	 
	    void testToString() {
	        String output = horse.toString();
	        assertTrue(output.contains("Thunder"));
	        assertTrue(output.contains("Mustang"));
	        assertTrue(output.contains("Black"));
	    }


}
