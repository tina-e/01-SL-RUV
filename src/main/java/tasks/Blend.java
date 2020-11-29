package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;
import ingredient.Product;
import tool.Blender;
import tool.Kitchentool;

public class Blend<Recipe> extends LeafTask<Recipe> {

    Ingredient[] ingredients;
    Blender blender;
    Product product;
    Kitchentool container;

    public Blend(Blender blender, Kitchentool container, Ingredient... ingredients) {
        this.ingredients = ingredients;
        this.blender = blender;
        this.container = container;
    }

    public Blend(Blender blender, Kitchentool container, Product product) {
        this.product = product;
        this.blender = blender;
        this.container = container;
    }

    @Override
    public Status execute() {
        StringBuilder sb = new StringBuilder("blending ");
        if (product != null) {
            product.transform("blended", true);
            sb.append(product.getName());
        } else {
            for (int i = 0; i < ingredients.length; i++) {
                ingredients[i].transform("blended", true);
                sb.append(ingredients[i].getName());
                if (i < ingredients.length - 1) sb.append(", ");
            }
        }
        sb.append(" with ");
        sb.append(blender.getName());
        sb.append(" in ");
        sb.append(container.getName());
        System.out.println(sb.toString());
        return Status.SUCCEEDED;
    }

    @Override
    protected Task<Recipe> copyTo(Task<Recipe> task) {
        return null;
    }
}
