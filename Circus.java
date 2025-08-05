

import java.util.ArrayList;
import java.util.List;


public class Circus {

	    private List<Animal> animals;
	    private List<Person> persons;
	    private List<Building> buildings;
	    private List<Ticket> tickets;

	    public Circus() {
	        animals = new ArrayList<>();
	        persons = new ArrayList<>();
	        buildings = new ArrayList<>();
	        tickets = new ArrayList<>();
	    }

	    // Add building
	    public void addBuilding(Building building) {
	    	buildings.add(building);
	    }

	    // Display building
	    public void displayBuilding() {
	    	for(Building b: buildings) {
	    		System.out.println(b.toString());
	    	}
	    }
	    // Add person
	    public void addPerson  (Person person) {
	    	persons.add(person);
}
	    // Display person
	    public void displayPersons() {
	    	for (Person p : persons) {
	    		System.out.println(p.toString());
	}
}

	    // Add animal
	    public void  addAnimal(Animal animal) {
	    	animals.add(animal);
}

	    // Display animal using toString() method
	    public void displayAnimals() {
	    	for(Animal a : animals) {
	    		System.out.println(a.toString());
	}
}


	    // Selection sort to sort animals by age
	    public void sortAnimalsByAge() {
	    	for (int i = 0; i < animals.size() - 1; i++) {
	            int minIndex = i;
	            for (int j = i + 1; j < animals.size(); j++) {
	                if (animals.get(j).getAge() < animals.get(minIndex).getAge()) {
	                    minIndex = j;
	                }
	            }
	            Animal temp = animals.get(i);
	            animals.set(i, animals.get(minIndex));
	            animals.set(minIndex, temp);
	        }
	    }
	    // Selection sort to sort animals by name
	    public void sortAnimalsByName() {
	        for (int i = 0; i < animals.size() - 1; i++) {
	            int minIndex = i;
	            for (int j = i + 1; j < animals.size(); j++) {
	                if (animals.get(j).getName().compareToIgnoreCase(animals.get(minIndex).getName()) < 0) {
	                    minIndex = j;
	                }
	            }
	            Animal temp = animals.get(i);
	            animals.set(i, animals.get(minIndex));
	            animals.set(minIndex, temp);
	        }
	    }
	    // Search for an animal by name
	    public Animal searchAnimalByName(String name) {
	        for (Animal a : animals) {
	            if (a.getName().equalsIgnoreCase(name)) {
	                return a;
	            }
	        }
	        return null;
	    }
	    
	    // Add ticket
	    public void addTicket(Ticket ticket) {
	        tickets.add(ticket);
	    }
	    // Generate ticket
	    public Ticket generateTicket(String dayOfWeek, double basePrice, int age) {
	        Ticket ticket = new Ticket(dayOfWeek, basePrice, age, dayOfWeek, age);  // Pass dayOfWeek, basePrice, age to Ticket constructor
	        addTicket(ticket);
	        return ticket;
	    }
	 // Display all ticket calculation details
	    public void displayTicketSummary() {
	        double grandTotal = 0.0;
	        for (Ticket t : tickets) {
	            t.displayTicketDetails();
	            grandTotal += t.calculatePrice();
	        }
	        System.out.printf("Final Total Amount: $%.2f%n", grandTotal);
	        System.out.println("Enjoy the show!");
	    }
}
