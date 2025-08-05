import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DogJUnitTest {
	 private Dog dog;
	    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    private final PrintStream originalOut = System.out;

	    @BeforeEach
	    void setUp() {
	        dog = new Dog("Buddy", 5, "Terrier", "Brown");
	        System.setOut(new PrintStream(outputStream));
	        outputStream.reset();
	    }

	    @Test
	    void testMove() {
	        dog.move();
	        String output = outputStream.toString().trim().toLowerCase();
	        assertTrue(output.contains("moving") || output.contains("move"));
	    }

	    @Test
	    void testMakeSound() {
	        dog.makeSound();
	        String output = outputStream.toString().trim().toLowerCase();
	        assertTrue(output.contains("woof"));
	    }

	    @Test
	    void testGetName() {
	        assertEquals("Buddy", dog.getName());
	    }

	    @Test
	    void testGetAge() {
	        assertEquals(5, dog.getAge());
	    }

	    @Test
	    void testEquals() {
	        Dog anotherDog = new Dog("Buddy", 5, "Terrier", "Brown");
	        assertEquals(dog, anotherDog);
	    }

	    @Test
	    void testToString() {
	        String result = dog.toString();
	        assertTrue(result.contains("Buddy"));
	        assertTrue(result.contains("Terrier"));
	    }

	    @Test
	    void testClone() {
	        Dog cloned = dog.clone();
	        assertEquals(dog, cloned);         // Same content
	        assertNotSame(dog, cloned);        // But different objects
	    }

	    @AfterEach
	    void tearDown() {
	        System.setOut(originalOut);
	        outputStream.reset();
	    }
	

	
	}


