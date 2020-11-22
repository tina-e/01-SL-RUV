package rezept;

import behaviortree.RecipeTree;
import com.badlogic.gdx.ai.btree.BehaviorTree;
import com.badlogic.gdx.ai.btree.utils.BehaviorTreeParser;
import kuechengeraet.Kuechengeraet;
import zutat.Zutat;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ImportiertesRezept {

    private String name;
    private BehaviorTree<RecipeTree> instructions;

    public ImportiertesRezept(String n) {
        name = n;
    }

    public void init() throws FileNotFoundException {
        Reader reader = new FileReader(("data/PestoUebung.tree"));
        BehaviorTreeParser<RecipeTree> parser = new BehaviorTreeParser<RecipeTree>(BehaviorTreeParser.DEBUG_HIGH);
        instructions = parser.parse(reader, new RecipeTree("Pesto", instructions));
    }

    public BehaviorTree<RecipeTree> getTree() throws FileNotFoundException {
        return instructions;
    }

    public void status() {
        /*Diese Funktion muss für unseren Textansatz noch implementiert werden. Wir könnten beispielsweise in RoestenText noch ein
        @TaskAttribute Integer amount einführen und dann hier checken, ob die Zutat durch diesen amount komplett verbraucht wird.
         */
    }

    public String name() {
        return name;
    }
}

