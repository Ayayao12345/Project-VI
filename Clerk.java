
public class Clerk extends Person{
	
	private String job;

	public Clerk(String name, int age, int yearsWorked, String job) {
	    super(name, age,yearsWorked);

	    this.job = job;
	}

	public String getJob() {
	    return job;
	}


	@Override
	public String toString() {
	    return String.format("Clerk [Name: %s, Age: %d, Years Worked: %d, Department: %s]",
                getName(), getAge(), getYearsWorked(), job);      
	}   
	     
	@Override
	
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (!(obj instanceof Clerk))
	        return false;
	    Clerk other = (Clerk) obj;
	    return getName().equals(other.getName()) &&
	           getAge() == other.getAge() &&
	           getYearsWorked() == other.getYearsWorked() &&
	           job.equals(other.job);
	}
	

	@Override
	public Clerk clone() {
	    return new Clerk(getName(), getAge(), getYearsWorked(), job);
	}
     
	
}
