import behaviortree.RecipeTree;
import com.badlogic.gdx.ai.btree.BehaviorTree;
import com.badlogic.gdx.ai.btree.Task;
import rezept.ImportiertesRezept;
import rezept.Rezept;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String [] args) throws FileNotFoundException {

        // Import des Behavior Trees aus .tree Datei (diese Zeilen ausklammern für programmatischen Ansatz):
        /*ImportiertesRezept myR;
        myR = new ImportiertesRezept("Pesto");*/

        //Programmatisches Erstellen des Behavior Trees (diese Zeilen ausklammern für Import aus .tree Datei):
        Rezept myR;
        myR = new Rezept("Pesto");

        // Ab jetzt ist der Code für beide Ansätze gleich
        BehaviorTree<RecipeTree> r;

        myR.init();

        r = myR.getTree();

        do {
            r.step();
            System.out.println("tree hat Status: " + r.getStatus());
        }
        while (r.getStatus() == Task.Status.RUNNING);

        myR.status();
    }
}