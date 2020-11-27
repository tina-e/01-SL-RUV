package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;
import ingredient.Product;
import quantity.Quantity;
import tool.Kitchentool;
import tool.MixingCup;

import javax.tools.Tool;

public class Add<Recipe> extends LeafTask<Recipe> {

    Kitchentool tool;
    Ingredient ingredient;
    Quantity quantity;
    Product product;

    public Add(Kitchentool tool, Ingredient ingredients, Quantity quantity, Product product) {
        this.ingredient = ingredients;
        this.tool = tool;
        this.quantity = quantity;
        this.product = product;
    }

    @Override
    public Status execute() {
        ingredient.transform("used", true);
        System.out.println("added " + quantity.toString() + " of " + ingredient.getName() +
                " to " + product.getName() + " in " + tool.getName());
        //todo: quantity zu product adden
        return Status.SUCCEEDED;
    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
