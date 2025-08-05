
public class Ticket {
	
	    private double basePrice;
	    private String dayOfWeek;
	    private int age;
	    private String seatLocation;
	    private int quantity ;
	    
	    
	    public Ticket(String dayOfWeek, double basePrice, int age, String seatLocation, int quantity ) {
	        this.basePrice = basePrice;
	        this.age = age;
	        this.dayOfWeek = dayOfWeek.toLowerCase();
	        this.quantity  = quantity;
	        this.seatLocation = seatLocation ;
	    }

	    // Calculate ticket price based on day of week and age
	 
     

	    public double  calculatePrice() {
	    	
	    	 // Apply discounts for weekdays
	    	double price  = basePrice ;
	    	if (dayOfWeek.equals("monday") || dayOfWeek.equals("tuesday")|| dayOfWeek.equals("wednesday") || dayOfWeek.equals("thursday") )  {
	    	price *= 0.90;	}       
	    	
	    	   // Apply age-based discounts 
	    	if (age <=12) {
	    		price *= 0.90 ;
	    	} else if (age >= 13 && age <= 21) {
	    		price *= 0.90 ;
	    	} else if(age >= 65) {
	    		price *= 0.95; 
	    	}
	    	
	    	  // seat Location adjustment 
		    if (seatLocation.equals("t-level")) {
		    	price *= 2.0 ;
		    } else if (seatLocation.equals("upper")) {
		    	price *= 0.95;
		    }
		    
	    	return price * quantity; 
	    	}
	    
	  
	    // Display the ticket details
	    public void displayTicketDetails() {
	    	String type = getCustomerType();
	    	double total = calculatePrice();
	    	double unitPrice = total / quantity ;
	    	
	    boolean isWeekday = dayOfWeek.equals("monday") || dayOfWeek.equals("tuesday") 
	    		|| dayOfWeek.equals("wednesday") || dayOfWeek.equals("thursday");
	    int dayDiscount = isWeekday ? 10 : 0 ;
	    int customerDiscount = 0 ; 
	    
	    if (type.equals("Child")|| type.equals("Student")) {
	    	customerDiscount = 10 ;
	    } else if (type.equals("Senior")) {
	    	customerDiscount = 5 ;
	    }
	    
	   
	    
	    System.out.printf("%d %s $%.2f (Day: %s, Day Discount: %d%%, Customer Type Discount: %d%%)%n",
                quantity,
                type.toLowerCase(),
                total,
                dayOfWeek.toUpperCase(),
                dayDiscount,
                customerDiscount);
	    
	    
	    }
	    
	   public String getCustomerType() {
		   if(age <= 12) return "Child";
		   if(age <= 21) return "Student";
		   if(age >= 65) return "Senior";
		   
		   return "Adult" ; // everyone else between the age of (22 - 64)
	   }
	   
	   public double getUnitPrice() {
		    return calculatePrice() / quantity;
		}

	       
	    public String toString() {
	    	
	        return String.format("Ticket [Day: %s, Age: %d, Price: $%.2f]",
	                             dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1), 
	                             age, calculatePrice());
	    }
	

}
