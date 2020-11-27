package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;
import recipe.Recipe;

import java.util.Scanner;

public class IsNotFull<Recipe> extends LeafTask<Recipe> {
    public String masse;

    @Override
    public Status execute() {
    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
