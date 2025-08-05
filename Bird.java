import java.util.Objects;

public class Bird implements Animal {


	
		//instance variables
	    private String name;
	    private int age;
	    private String species;
	    private String color;

	    //constructor
	    public Bird(String name, int age, String species, String color) {
	        this.name = name;
	        this.age = age;
	        this.species = species;
	        this.color = color;
	    }

	    @Override
		//move()
	    public void move() {
	    System.out.println(name + "is flying the air");
	    }
	    @Override
		//makeSound()
	    public void makeSound() {
	    System.out.println(name + "chirps melodiously!");
	    }
	    @Override
	    //getName()
	    public String getName() {
	    	return name ;
	    }
	    @Override
	    //getAge()
	    public int getAge() {
	    	return age ;
	    	}
	    
		
	    @Override
		//equals()
			// Check for reference equality
			// Check for null or different class
		// Compare fields for logical equality
	    
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (!(obj instanceof Bird)) return false;
	        Bird other = (Bird) obj;
	        return age == other.age &&
	               Objects.equals(name, other.name) &&
	               Objects.equals(species, other.species) &&
	               Objects.equals(color, other.color);
	    }
	    @Override
		//toString()   
	    public String toString() {
	        return String.format("Bird{name='%s', age=%d, species='%s', color='%s'}",
	                name, age, species, color);
	    
	        }
	    //  Implement clone() if needed
	    public Bird clone() {
	        return new Bird(name, age, species, color);
	    }
	    }
