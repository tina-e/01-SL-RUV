package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;

public class Pluck<Recipe> extends LeafTask<Recipe> {

    private Ingredient ingredient;
    public Pluck(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public Status execute() {
        System.out.println("plucking " + ingredient.getName());
        return Status.SUCCEEDED;
    }

    @Override
    protected Task<Recipe> copyTo(Task<Recipe> task) {
        return null;
    }
}
