package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;
import tool.Blender;

public class Blend<Recipe> extends LeafTask<Recipe> {

    Ingredient[] ingredients;
    Blender blender;

    public Blend(Blender blender, Ingredient... ingredients) {
        this.ingredients = ingredients;
        this.blender = blender;
    }

    @Override
    public Status execute() {
        StringBuilder sb = new StringBuilder("blending ");
        for (int i = 0; i < ingredients.length; i++) {
            sb.append(ingredients[i].getName());
            if (i < ingredients.length - 1) sb.append(", ");
        }
        sb.append(" in " + blender.getName());
        System.out.println(sb.toString());
        return Status.SUCCEEDED;
    }

    @Override
    protected Task<Recipe> copyTo(Task<Recipe> task) {
        return null;
    }
}
