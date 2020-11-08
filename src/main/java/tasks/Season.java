package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;
import recipe.Recipe;

public class Season<Recipe> extends LeafTask<Recipe> {

    Ingredient[] ingredients;

    public Season(Ingredient... ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public Status execute() {
        StringBuilder sb = new StringBuilder("seasoning with ");
        for (int i = 0; i < ingredients.length; i++) {
            sb.append(ingredients[i].getName());
            if (i < ingredients.length -1) sb.append(" and ");
        }
        System.out.println(sb.toString());
        return Status.SUCCEEDED;
    }

    @Override
    protected Task<Recipe> copyTo(Task<Recipe> task) {
        return null;
    }
}
