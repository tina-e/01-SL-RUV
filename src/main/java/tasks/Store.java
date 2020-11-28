package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;
import ingredient.Product;
import recipe.Recipe;

public class Store extends LeafTask<Recipe> {
    String howToStore;
    Product product;
    public Store(Product product, String howToStore) {
        this.product = product;
        this.howToStore = howToStore;
    }

    @Override
    public Status execute() {
        System.out.println("Storing "+product.getName()+ howToStore);
        return Status.SUCCEEDED;
    }

    @Override
    protected Task<Recipe> copyTo(Task<Recipe> task) {
        return null;
    }
}