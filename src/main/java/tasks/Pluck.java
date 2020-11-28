package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;

public class Pluck<Recipe> extends LeafTask<Recipe> {

    private int amount;
    private Ingredient ingredient;

    public Pluck(Ingredient ingredient, int amount) {
        this.ingredient = ingredient;
        this.amount = amount;
    }
    public Pluck(Ingredient ingredient) {
        this.ingredient = ingredient;
        this.amount = 10;
    }

    @Override
    public Status execute() {
        System.out.println("plucking " + amount + " grams of " + ingredient.getName());
        return Status.SUCCEEDED;
    }

    @Override
    protected Task<Recipe> copyTo(Task<Recipe> task) {
        return null;
    }
}
