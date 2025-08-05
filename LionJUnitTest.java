import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	
public class LionJUnitTest {
	


	    private Lion lion1;
	    private Lion lion2;

	    
	    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    private final PrintStream originalOut = System.out;
	    @BeforeEach
	    // setUp
	    public void setUp() {
	        lion1 = new Lion("Simba", 5, "Lion", "Golden");
	        lion2 = new Lion("King", 8, "Lion", "White");
	        System.setOut(new PrintStream(outputStream)); // Redirect output
	    }

	    @Test
	    //testConstructor
	    public void testConstructor() {
	        assertNotNull(lion1);
	        assertEquals("Simba", lion1.getName());
	        assertEquals(5, lion1.getAge());
	    }

	    @Test
	    //testMove
	    public void testMove() {
	        // Assuming move() prints something to System.out
	        lion1.move();  // Optional: redirect output and check contents
	        String output = outputStream.toString().trim();
	        assertTrue(output.toLowerCase().contains("move"));
	    }

	    @Test
	    // testMakeSound
	    public void testMakeSound() {
	        // Assuming makeSound() prints "Roar" or something similar
	        lion1.makeSound();  // Optional: redirect output and check contents
	        String output = outputStream.toString().trim();
	        assertTrue(output.toLowerCase().contains("roar"));
	    }

	    @Test
	    //testGetName 
	    public void testGetName() {
	        assertEquals("Simba", lion1.getName());
	    }

	    @Test
	    // testGetAge
	    public void testGetAge() {
	        assertEquals(5, lion1.getAge());
	    }

	    @Test
	    //testEquals
	    public void testEquals() {
	        Lion anotherLion = new Lion("Simba", 5, "Lion", "Golden");
	        assertEquals(lion1, anotherLion);
	        assertNotEquals(lion1, lion2);
	    }

	    @Test
	    //testToString
	    public void testToString() {
	        String output = lion1.toString();
	        assertTrue(output.contains("Simba"));
	        assertTrue(output.contains("Lion"));
	        assertTrue(output.contains("Golden"));
	    }
	    
	    @Test
	  
	    
	    public void testClone() {
	        Lion clonedLion = lion1.clone(); // no try-catch needed
	        assertEquals(lion1, clonedLion);         // Same data
	        assertNotSame(lion1, clonedLion);        // Different objects
	    }


	    
	    @org.junit.jupiter.api.AfterEach
	    public void tearDown() {
	        System.setOut(originalOut);
	        outputStream.reset(); // Clean up output for next test
	    }

}
