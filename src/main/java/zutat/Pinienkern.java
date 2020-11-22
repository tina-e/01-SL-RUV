package zutat;

import quantitaet.Quantitaet;

public class Pinienkern extends Zutat {
    public Pinienkern() {
        super("pinenkern");
    }

    public Pinienkern(Quantitaet q) {
        super("pinienkern", q);
    }

    public void verbrauchen() {
        verbraucht = true;
    }
}
