package quantity;

abstract public class Quantity {

    protected String name;
    protected double amount;

    public Quantity() {
    }

    public Quantity(String n, double m) {
        name = n;
        amount = m;
    }

    public double getAmount(){
        return amount;
    }
}
