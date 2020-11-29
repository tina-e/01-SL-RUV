package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;
import ingredient.Product;

public class PutOn extends LeafTask {

    private final Product product;
    private final Ingredient ingredient;

    public PutOn(Product product, Ingredient ingredient) {
        this.product = product;
        this.ingredient = ingredient;
    }

    @Override
    public Status execute() {
        System.out.println("put " + ingredient.getName() + " on " + product.getName());
        return Status.SUCCEEDED;
    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
