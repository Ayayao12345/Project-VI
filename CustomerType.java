
public enum CustomerType {
    CHILD(0.10),
    STUDENT(0.10),
    ADULT(0.0),
    SENIOR(0.05);

    private final double discount;

    CustomerType(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
