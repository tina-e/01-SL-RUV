package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;
import recipe.Recipe;
import tool.Grater;
import tool.Kitchentool;

public class Grate<Recipe> extends LeafTask<Recipe> {

    Ingredient ingredient;
    Grater grater;

    public Grate(Ingredient ingredient, Grater grater){
        this.ingredient = ingredient;
        this.grater = grater;
    }

    @Override
    public Status execute() {
        ingredient.transform("grated", true);
        System.out.println("used " + grater.getName() + " to grate " + ingredient.getName());
        return Status.SUCCEEDED;
    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
