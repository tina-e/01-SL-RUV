package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;
import tool.MixingCup;

public class Add<Recipe> extends LeafTask<Recipe> {

    Ingredient[] ingredients;
    MixingCup mixingCup;

    public Add(MixingCup mixingCup, Ingredient... ingredients) {
        this.ingredients = ingredients;
        this.mixingCup = mixingCup;
    }

    @Override
    public Status execute() {
        StringBuilder sb = new StringBuilder("mixing ");
        for (int i = 0; i < ingredients.length; i++) {
            sb.append(ingredients[i].getName());
            if (i < ingredients.length - 1) sb.append(", ");
        }
        sb.append(" in " + mixingCup.getName());
        System.out.println(sb.toString());
        return Status.SUCCEEDED;
    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
