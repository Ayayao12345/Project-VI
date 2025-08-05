
public enum DayOfWeek {
	
	MONDAY(0.10),
    TUESDAY(0.10),
    WEDNESDAY(0.10),
    THURSDAY(0.10),
    FRIDAY(0.10),
    SATURDAY(0.0),
    SUNDAY(0.0);

    private final double discount;

    DayOfWeek(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
	

}
