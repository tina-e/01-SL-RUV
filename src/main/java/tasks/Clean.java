package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;

public class Clean<Recipe> extends LeafTask<Recipe> {

    private Ingredient ingredient;

    public Clean(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public Status execute() {
        System.out.println("washing " + ingredient.getName());
        return Status.SUCCEEDED;
    }

    @Override
    protected Task<Recipe> copyTo(Task<Recipe> task) {
        return null;
    }
}
