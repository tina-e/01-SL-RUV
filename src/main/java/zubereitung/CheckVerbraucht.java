package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import zutat.Zutat;

public class CheckVerbraucht extends LeafTask {
    Zutat z;

    public CheckVerbraucht(Zutat z){
        this.z = z;
    }

    public Status execute() {
        if (z.istVerbraucht()){
            return Status.FAILED;
        }
        else return Status.SUCCEEDED;
    }

    protected Task copyTo(Task task) {
        return null;
    }
}
