package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;
import recipe.Recipe;
import tool.Jar;

import java.util.Scanner;

public class IsNotFull<Recipe> extends LeafTask<Recipe> {

    private Jar jar;

    public IsNotFull(Jar jar) {
        this.jar = jar;
    }

    @Override
    public Status execute() {
        if (jar.getSpace() <= 0) {
            System.out.println(jar.getName() + " ist voll.");
            return Status.FAILED;
        }
        return Status.SUCCEEDED;
    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
