
public class Acrobatic extends Person{
	    private String job;

	    public Acrobatic(String name, int age, int yearsWorked, String job) {
	        super(name, age, yearsWorked);
	        this.job = job;
	    }

	    public String getJob() {
	        return job;
	    }

	    @Override
	    public String toString() {
	        return String.format("Acrobatic [Name: %s, Age: %d, Years Worked: %d, Job: %s]",
	        getName(), getAge(), getYearsWorked(),job);
	    }   
	  
	@Override 
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null|| getClass() != obj.getClass() )
			return false;
		
		Acrobatic other = (Acrobatic) obj ;
		return getAge() == other.getAge() &&
				getYearsWorked() == other.getYearsWorked() &&
				getName().equals(other.getName()) &&
				job.equals(other.job);
	}
	@Override 
	public Acrobatic clone() {
		return new Acrobatic (getName(), getAge(), getYearsWorked(),job);
	}
}
