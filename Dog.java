import java.util.Objects;

public class Dog implements Animal, Cloneable{
	
	    // Instance variables
	    private String name;
	    private int age;
	    protected String species;
	    protected String color;

	    // Constructor
	    public Dog(String name, int age, String species, String color) {
	        this.name = name;
	        this.age = age;
	        this.species = species;
	        this.color = color;
	    }

	    @Override
		//move()
	    
	    public void move() {
	        System.out.println(name + " is moving");
	    }

		
	    @Override
		//makeSound()
	    public void makeSound () {
	    	System.out.println(name  +  "says: Woof Woof!");
	    	
	    }
	    @Override
		//getName()
		public String getName () {
	    	return name ;
	    }
	    @Override
		//getAge()
	    public int getAge() {
	    	return age ;
	    	
	    }
	    @Override
		//clone()
	    public Dog clone() {
	    	return new Dog (name, age, species, color);
	    } 
	    @Override
	    
		//equals()
	    public boolean equals(Object obj) {
	    	// check for reference equality
	    	if (this == obj) 
	    		return true;
	    	// Check for null or different class
	    	if(obj == null || getClass() != obj.getClass())
	    		return false;
	    	// Compare fields for logical equality
	    	Dog other =(Dog)obj;
	    	return age == other.age && 
	    			Objects.equals(name, other.name) &&
	    			Objects.equals(species, other.species) &&
	                Objects.equals(color, other.color);
	     }
	    
	    
			
			
			

	    @Override
		//toString() 
	    
	    
	    public String toString() {
	        return String.format("Dog [Name: %s, Age: %d, Species: %s, Color: %s]", name, age, species, color);
	    }

}
