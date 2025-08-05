import java.util.Objects;
public class Lion implements Animal, Cloneable  {


	
		//instance variables
	    private String name;
	    private int age;
	    private String species;
	    private String color;

	    //constructor
	    public Lion(String name, int age, String species, String color) {
	        this.name = name;
	        this.age = age;
	        this.species = species;
	        this.color = color;
	    }

	    @Override
		//move()
	    public void move() {
	    	System.out.println(name + " the lion moves silently across the arena.");

	    }
		
	    @Override
		//makeSound()
	    public void makeSound() {
	        System.out.println("Roar! I'm " + name + " the lion.");
	    }
	    @Override
		//getName()
	    public String getName() {
	        return name;
	    }
	    @Override
		//getAge()
	    public int getAge() {
	        return age;
	    }
	    @Override
		//equals()
			// Check for reference equality
			// Check for null or different class
			// Compare fields for logical equality	 
	    public boolean equals(Object obj) {
	        if (this == obj) return true; // same reference
	        if (obj == null || getClass() != obj.getClass()) return false; // null or different class
	        Lion other = (Lion) obj;
	        return age == other.age &&
	               Objects.equals(name, other.name) &&
	               Objects.equals(species, other.species) &&
	               Objects.equals(color, other.color);
	    }
	    
	    @Override
	    public Lion clone() {
	        return new Lion(name, age, species, color);
	    }

	    @Override
		//toString()
	    public String toString() {
	        return String.format("Lion [Name=%s, Age=%d, Species=%s, Color=%s]",
	                name, age, species, color);
	    }

	

}
