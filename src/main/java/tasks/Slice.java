package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;

public class Slice<Recipe> extends LeafTask<Recipe> {
    private Ingredient ingredient;

    public Slice(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public Task.Status execute() {
        System.out.println("slice " + ingredient.getName());
        ingredient.transform("sliced", true);
        return Task.Status.SUCCEEDED;
    }

    @Override
    protected Task<Recipe> copyTo(Task<Recipe> task) {
        return null;
    }
}
