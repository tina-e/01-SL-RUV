package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;

public class Wash <Recipe> extends LeafTask<Recipe> {
    @Override
    public Status execute() {
        return null;
    }

    @Override
    protected Task<Recipe> copyTo(Task<Recipe> task) {
        return null;
    }
}
