package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;
import ingredient.Product;
import quantity.Quantity;
import tool.Kitchentool;

public class Add<Recipe> extends LeafTask<Recipe> {

    Kitchentool tool;
    Ingredient ingredient;
    Quantity quantity;
    Product product;

    public Add(Kitchentool tool, Ingredient ingredient, Quantity quantity, Product product) {
        this.ingredient = ingredient;
        this.tool = tool;
        this.quantity = quantity;
        this.product = product;
    }

    public Add(Kitchentool tool, Ingredient ingredient, Product product) {
        this.ingredient = ingredient;
        this.tool = tool;
        this.product = product;
        this.quantity = ingredient.getQuantity();
    }

    public Add(Kitchentool tool, Ingredient ingredient) {
        this.ingredient = ingredient;
        this.tool = tool;
        this.quantity = ingredient.getQuantity();
    }

    @Override
    public Status execute() {
        if(this.product != null){
            ingredient.transform("used", true);
            System.out.println("added " + quantity.getAmount() + " of " + ingredient.getName() +
                    " to " + product.getName() + " in " + tool.getName());
            product.addAmount(quantity.getAmount());
            return Status.SUCCEEDED;
        }
        System.out.println("added " + ingredient.getName()+
                " to " + tool.getName());
        return Status.SUCCEEDED;
    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
