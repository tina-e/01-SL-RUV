package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import rezept.Rezept;

public class TestTask extends LeafTask {
    private int count = 0;
    @Override
    public Status execute() {
        Rezept r = (Rezept)getObject();

        System.out.println(r.name() + " aktueller count: " + count);
        if (count == 0) return Status.SUCCEEDED;
        else {
            count --;
            return Status.RUNNING;
        }
    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
