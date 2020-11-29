package quantity;

public class BigSpoon extends Quantity {

    private static final int CONVERSION_RATE_TO_GRAMS = 15;

    public BigSpoon() {
        super("EL", 0);
    }

    public BigSpoon(double amount) {
        super("EL", amount);
    }

    @Override
    public double getAmount() {
        return super.getAmount() * CONVERSION_RATE_TO_GRAMS;
    }
}
