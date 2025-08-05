	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import java.io.ByteArrayOutputStream;
	import java.io.PrintStream;
public class BirdJUnitTest {

	    private Bird bird;
	    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    private final PrintStream originalOut = System.out;

	    @BeforeEach
	    void setUp() {
	        bird = new Bird("Tweety", 2, "Canary", "Yellow");
	        		  outputStream.reset();
	        System.setOut(new PrintStream(outputStream));
	    }

	    @Test
		//testMove()
	    void testMove() {
	        bird.move();
	        String output = outputStream.toString().trim();
	        assertTrue(output.toLowerCase().contains("fly"));
	    }

	    @Test
		//testMakeSound()
	    void testMakeSound() {
	        bird.makeSound();
	        String output = outputStream.toString().trim();
	        assertTrue(output.toLowerCase().contains("chirp"));
	    }

	    @Test
		//testGetName()
	    void testGetName() {
	        assertEquals("Tweety", bird.getName());
	    }

	    @Test
		//testGetAge()
	    void testGetAge() {
	        assertEquals(2, bird.getAge());
	    }

	    @Test
		//testEquals()
	    void testEquals() {
	        Bird anotherBird = new Bird("Tweety", 2, "Canary", "Yellow");
	        assertEquals(bird, anotherBird);
	    }

	    @Test
		//testToString()
	    void testToString() {
	        String output = bird.toString();
	        assertTrue(output.contains("Tweety"));
	        assertTrue(output.contains("Canary"));
	        assertTrue(output.contains("Yellow"));
	    }
	  
	    

	    @org.junit.jupiter.api.AfterEach
	    void tearDown() {
	        System.setOut(originalOut);
	    }
	
}
