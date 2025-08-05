import java.util.InputMismatchException;
import java.util.Scanner;

public class CircusDriverApp {
	
	
	    public static void main(String[] args) {
	        Circus circus = new Circus();
	        Scanner scanner = new Scanner(System.in);
	        boolean exit = false;

	        System.out.println("Welcome to Bob's Circus Management System!");

	        while (!exit) {
	            try {
	                // Display menu
	                System.out.println("\nMenu:");
	                System.out.println("1. Add Animal");
	                System.out.println("2. Add Person");
	                System.out.println("3. Add Building");
	                System.out.println("4. Generate Ticket");
	                System.out.println("5. Display All Animals");
	                System.out.println("6. Display All Persons");
	                System.out.println("7. Display All Buildings");
	                System.out.println("8. Sort Animals by Age");
	                System.out.println("9. Sort Animals by Name");
	                System.out.println("10. Search Animal by Name");
	                System.out.println("11. Exit\n");

	                System.out.print("Choose an option: ");
	              
	                // Use validateInput method
	                int choice = 0;
	                boolean validInput = false;

	                // Retry until valid input is received
	                while (!validInput) {
	                    try {
	                        choice = validateInput(scanner);
	                        validInput = true;
	                        
	                    } catch (CustomInputMismatchException e) {
	                        System.out.println(e.getMessage()); // Print error message 
	                        System.out.print("Please enter a valid number:");
	                    }
	                }
	   

	                switch (choice) {
	                    case 1:
	                        handleAddAnimal(circus, scanner);
	                        break;
	                    case 2:
	                        handleAddPerson(circus, scanner);
	                        break;
	                    case 3:
	                        handleAddBuilding(circus, scanner);
	                        break;
	                    case 4:
	                        handleGenerateTicket(scanner);
	                        break;
	                    case 5:
	                        System.out.println("Displaying all animals:");
	                        System.out.println("----------------------");
	                        circus.displayAnimals();
	                        break;
	                    case 6:
	                        System.out.println("Displaying all persons:");
	                        System.out.println("----------------------");
	                        circus.displayPersons();
	                        break;
	                    case 7:
	                        System.out.println("Displaying all buildings:");
	                        System.out.println("------------------------");
	                        circus.displayBuilding();
	                        break;
	                    case 8:
	                        System.out.println("Sorting animals by age...");
	                        circus.sortAnimalsByAge();
	                        System.out.println("Animals sorted by age.");
	                        break;
	                    case 9:
	                        System.out.println("Sorting animals by name...");
	                        circus.sortAnimalsByName();
	                        System.out.println("Animals sorted by name.");
	                        break;                       
	                    case 10:
	                        System.out.print("Enter the name of the animal to search: ");
	                        scanner.nextLine(); // Consume the leftover newline
	                        String searchName = scanner.nextLine();
	                        circus.searchAnimalByName(searchName);
	                        break;
	                    case 11:
	                        exit = true;
	                        System.out.println("Exiting Bob's Circus Management System. Goodbye!\n");
	                        break;
	                    default:
	                        System.out.println("Invalid option. Please choose again.");
	                }
	       
	                } catch (Exception e) {
			            System.out.println("An unexpected error occurred: " + e.getMessage());
			            e.printStackTrace();
	                } 
	            
	        }

	        scanner.close();
	    }

	    
	    private static int validateInput(Scanner scanner) throws CustomInputMismatchException {
	        try {
	            return scanner.nextInt();
	        } catch (InputMismatchException e) {
	            scanner.nextLine(); // clear bad input
	            throw new CustomInputMismatchException ("Invalid input. Please enter a number.");
	        }
	    }
	    
	    

	    private static void handleGenerateTicket(Scanner scanner) {
	        double totalAmount = 0;
	        double basePrice;
	        StringBuilder ticketDetails = new StringBuilder();
	        boolean addMoreTickets = true;

	        System.out.print("\nEnter ticket base price: ");
	        basePrice = scanner.nextDouble();
	        scanner.nextLine();

	        ticketDetails.append(String.format("Regular ticket price: $%.2f%n%n", basePrice));

	        while (addMoreTickets) {
	            // Select day of the week
	            System.out.println("\nSelect day of the week:");
	            for (int i = 0; i < DayOfWeek.values().length; i++) {
	                DayOfWeek day = DayOfWeek.values()[i];
	                if (day.getDiscount() > 0) {
	                    System.out.printf("%d. %s (%.0f%% discount)%n", i + 1, day, day.getDiscount() * 100);
	                } else {
	                    System.out.printf("%d. %s%n", i + 1, day);
	                }
	            }
	            System.out.print("\nSelecte day of week: ");
	            int dayChoice = scanner.nextInt();
	            scanner.nextLine();

	            if (dayChoice < 1 || dayChoice > DayOfWeek.values().length) {
	                System.out.println("Invalid choice. Please select a valid day.");
	                continue;
	            }

	            DayOfWeek selectedDay = DayOfWeek.values()[dayChoice - 1];
	            double dayDiscount = selectedDay.getDiscount();

	            // Select customer type
	            System.out.println("\nEnter customer type:");
	            System.out.println("1. Child (10% discount)");
	            System.out.println("2. Student (10% discount)");
	            System.out.println("3. Adult");
	            System.out.println("4. Senior (5% discount)");
	            System.out.print("\nEnter your choice: ");
	            int customerType = scanner.nextInt();
	            scanner.nextLine();

	            double customerDiscount = 0.0;
	            String customerTypeName = "";
	            switch (customerType) {
	                case 1:
	                    customerDiscount = 0.10;
	                    customerTypeName = "child";
	                    break;
	                case 2:
	                    customerDiscount = 0.10;
	                    customerTypeName = "student";
	                    break;
	                case 3:
	                    customerTypeName = "adult";
	                    break;
	                case 4:
	                    customerDiscount = 0.05;
	                    customerTypeName = "senior";
	                    break;
	                default:
	                    System.out.println("Invalid customer type. Please try again.");
	                    continue;
	            }

	            // Select seat location
	            System.out.println("\nSeat Location in the Arena:");
	            System.out.println("1. Lower level");
	            System.out.println("2. T-level (double ticket price)");
	            System.out.println("3. Upper level (5% discount)");
	            System.out.print("\nEnter your choice: ");
	            int seatLocation = scanner.nextInt();
	            scanner.nextLine();

	            double seatMultiplier = (seatLocation == 2) ? 2.0 : 1.0;
	            double seatDiscount = (seatLocation == 3) ? 0.05 : 0.0;

	            System.out.print("Enter number of tickets: ");
	            int numberOfTickets = scanner.nextInt();
	            scanner.nextLine();

	            // Calculate discounts and total price for this batch of tickets
	            double finalPrice = basePrice * seatMultiplier;
	            finalPrice -= finalPrice * (dayDiscount + customerDiscount + seatDiscount);


	            // Add to total amount
	            double batchTotal = finalPrice * numberOfTickets;
	            totalAmount += batchTotal; // add to grand total

	            // Append details of this batch to the ticket details

	            // Append details of this batch to the ticket details
	            ticketDetails.append(String.format(
	            	    "Customer Type: %s | Day: %s | Tickets: %d | Final Price per Ticket: $%.2f | Batch Total: $%.2f%n",
	            	    customerTypeName, selectedDay.name(), numberOfTickets, finalPrice, batchTotal
	            	));


	            // Ask user to add more tickets
	            System.out.print("\nDo you want to add more tickets? (y/n): ");
	            String response = scanner.nextLine().trim().toLowerCase();
	            addMoreTickets = response.equals("y");
	        }

	        // Display ticket calculation details
	        System.out.println("\nTicket Calculation Details:");
	        System.out.println("---------------------------");
	        System.out.println(ticketDetails);

	        // Display final total amount
	        System.out.printf("Final Total Amount: $%.2f%n", totalAmount);
	        System.out.println("Enjoy the show!");
	    }
	    	// handleAddAnimal
	    private static void handleAddAnimal(Circus circus, Scanner scanner) {
	        System.out.println("\nChoose animal type to add:");
	        System.out.println("1. Dog");
	        System.out.println("2. Horse");
	        System.out.println("3. Lion");
	        System.out.println("4. Bird");
	        System.out.print("Enter your choice: ");
	        
	        int animalType = scanner.nextInt();
	        scanner.nextLine(); // consume newline

	        System.out.print("Enter animal name: ");
	        String name = scanner.nextLine();

	        System.out.print("Enter animal age: ");
	        int age = scanner.nextInt();
	        scanner.nextLine(); // consume newline

	        System.out.print("Enter animal species: ");
	        String species = scanner.nextLine();

	        System.out.print("Enter animal color: ");
	        String color = scanner.nextLine();

	        Animal animal = null;
	        switch (animalType) {
	            case 1:
	                animal = new Dog(name, age, species, color);
	                break;
	            case 2:
	                animal = new Horse(name, age, species, color);
	                break;
	            case 3:
	                animal = new Lion(name, age, species, color);
	                break;
	            case 4:
	                animal = new Bird(name, age, species, color);
	                break;
	            default:
	                System.out.println("Invalid animal type.");
	                return;
	        }

	        circus.addAnimal(animal);
	        System.out.println("Animal added successfully!");
	    }
	    	// handleAddPerson
	    private static void handleAddPerson(Circus circus, Scanner scanner) {
	        System.out.println("\nChoose person type to add:");
	        System.out.println("1. Clerk");
	        System.out.println("2. Acrobatic");
	        System.out.print("Enter your choice: ");

	        int personType = scanner.nextInt();
	        scanner.nextLine(); // consume newline

	        System.out.print("Enter person's name: ");
	        String name = scanner.nextLine();

	        System.out.print("Enter person's age: ");
	        int age = scanner.nextInt();
	        scanner.nextLine(); // consume newline

	        System.out.print("Enter years worked: ");
	        int yearsWorked = scanner.nextInt();
	        scanner.nextLine(); // consume newline

	        Person person = null;

	        switch (personType) {
	            case 1:
	                System.out.print("Enter department: ");
	                String department = scanner.nextLine();
	                person = new Clerk(name, age, yearsWorked, department);
	                break;
	            case 2:
	                System.out.print("Enter job title: ");
	                String job = scanner.nextLine();
	                person = new Acrobatic(name, age, yearsWorked, job);
	                break;
	            default:
	                System.out.println("Invalid person type.");
	                return;
	        }

	        circus.addPerson(person);
	        System.out.println("Person added successfully!");
	    }
	     // HandleAddBuilding()
	    private static void handleAddBuilding(Circus circus, Scanner scanner) {
	    	 System.out.println("\nChoose building type to add:");
	    	    System.out.println("1. Arena");
	    	    System.out.println("2. Ticketing Office");
	    	    System.out.print("Enter your choice: ");

	    	    int buildingType = scanner.nextInt();
	    	    scanner.nextLine(); // consume newline

	    	    Building building = null;

	    	    switch (buildingType) {
	    	        case 1:
	    	            System.out.print("Enter arena color: ");
	    	            String color = scanner.nextLine();

	    	            System.out.print("Enter arena length: ");
	    	            double length = scanner.nextDouble();
	    	            scanner.nextLine();

	    	            System.out.print("Enter arena width: ");
	    	            double width = scanner.nextDouble();
	    	            scanner.nextLine();

	    	            building = new Arena(color, length, width);
	    	            break;

	    	        case 2:
	    	            System.out.print("Enter ticket office color: ");
	    	            String toColor = scanner.nextLine();

	    	            System.out.print("Enter office length: ");
	    	            double toLength = scanner.nextDouble();
	    	            scanner.nextLine();

	    	            System.out.print("Enter office width: ");
	    	            double toWidth = scanner.nextDouble();
	    	            scanner.nextLine();

	    	            building = new TicketingOffice(toColor, toLength, toWidth);
	    	            break;

	    	        default:
	    	            System.out.println("Invalid building type.");
	    	            return;
	    	    }

	    	    circus.addBuilding(building);
	    	    System.out.println("Building added successfully!");
	    }
	    

	}
