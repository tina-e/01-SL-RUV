package preparation;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;

public class TestTask<Rezept> extends LeafTask<Rezept> {

    private int count = 10;

    @Override
    public Status execute() {
        //Rezept r = getObject();
        //System.out.println("ausgeführt.");
        
        System.out.println("aktueller count: " + count);

        if(count == 0) return Status.SUCCEEDED;

        count--;
        return Status.RUNNING;
    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
