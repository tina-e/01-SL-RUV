package zutat;

import quantitaet.Quantitaet;

abstract public class Zutat {
    protected String name;
    protected boolean verbraucht;
    protected Quantitaet quant;

    public Zutat() {
        verbraucht = false;
    }

    public Zutat(String n) {
        verbraucht = false;
        name = n;
    }

    public Zutat(String n, Quantitaet q) {
        name = n;
        verbraucht = false;
        quant = q;
    }

    public String bezeichner() {
        return name;
    }

    abstract public void verbrauchen();

    public boolean istVerbraucht() {
        return verbraucht;
    }
}
