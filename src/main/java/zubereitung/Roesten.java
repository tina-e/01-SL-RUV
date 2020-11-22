package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import kuechengeraet.Kuechengeraet;
import zutat.Zutat;

import java.util.ArrayList;

public class Roesten extends LeafTask {

    // Dieser Roesten Task eignet sich nur für den programmatischen Ansatz!
    ArrayList<Zutat> zutaten;
    Kuechengeraet k;

    public Roesten(Zutat z, Kuechengeraet k) {
        super();

        this.k = k;

        zutaten = new ArrayList<Zutat>();
        zutaten.add(z);
    }
    public Status execute() {
        System.out.println("ich röste " + zutaten.size() + " Zutaten.");

        for (Zutat z : zutaten) {
            z.verbrauchen();
        }

        return Status.SUCCEEDED;
    }

    protected Task copyTo(Task task) {
        return null;
    }
}
