
public class CustomInputMismatchException  extends Exception {
	
	    public CustomInputMismatchException(String message) {
	        super(message);
	    }

	    @Override
	    public String getMessage() {
	        return "Custom Input Error: " + super.getMessage();
	    }

	}
