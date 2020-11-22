package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;

public class RoestenText extends LeafTask {
    // Diesen Roesten Task nutzen wir in unserer .tree Datei!
    @TaskAttribute public String zutat;
    @TaskAttribute public String geraet;

    public Status execute() {
        System.out.println("ich röste " + zutat + " in der " + geraet);
        return Status.SUCCEEDED;
    }

    protected Task copyTo(Task task) {
        return null;
    }
}
