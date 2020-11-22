package rezept;

import behaviortree.RecipeTree;
import com.badlogic.gdx.ai.btree.BehaviorTree;
import com.badlogic.gdx.ai.btree.branch.Sequence;
import kuechengeraet.Kuechengeraet;
import kuechengeraet.Pfanne;
import quantitaet.Essloeffel;
import zubereitung.CheckVerbraucht;
import zubereitung.Roesten;
import zutat.Pinienkern;
import zutat.Zutat;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Rezept {
    private String name;
    private HashMap<String, Kuechengeraet> geraete;
    private HashMap<String, Zutat> zutaten;
    private BehaviorTree<RecipeTree> instructions;

    public Rezept(String n) {
        name = n;

        geraete = new HashMap<String, Kuechengeraet>();
        zutaten = new HashMap<String, Zutat>();

        instructions = new RecipeTree("Pesto", instructions);
    }

    public void init() {
        Zutat z = new Pinienkern(new Essloeffel(1));
        Kuechengeraet k = new Pfanne();

        geraete.put(k.bezeichner(), k);
        zutaten.put(z.bezeichner(), z);

        Sequence sequence = new Sequence();

        sequence.addChild(new CheckVerbraucht(z));
        sequence.addChild(new Roesten(z,k));

        instructions.addChild(sequence);
    }

    public BehaviorTree<RecipeTree> getTree() {
        return instructions;
    }

    public void status() {
        Set<Map.Entry<String, Zutat>> zs = zutaten.entrySet();

        for (Map.Entry<String, Zutat>s: zs) {
            System.out.println(s.getValue().bezeichner() + " ist verbaucht: " + s.getValue().istVerbraucht());
        }
    }
    public String name() {
        return name;
    }
}
