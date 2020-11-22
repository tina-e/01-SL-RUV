package quantitaet;

abstract public class Quantitaet {
    protected String name;
    protected double menge;

    public Quantitaet() {
    }

    public Quantitaet(String n, double m) {
        name = n;
        menge = m;
    }
}
