package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Product;
import tool.Jar;

public class Bottle extends LeafTask {

    private Jar jar;
    private Product product;

    public Bottle(Jar jar, Product product) {
        this.jar = jar;
        this.product = product;
    }

    @Override
    public Status execute() {
        int amount = 5;
        jar.addAmount(amount);
        product.subAmount(amount);
        System.out.println("bottled " + amount + " of " + product.getName() + " in " + jar.getName() + ".");
        return Status.SUCCEEDED;
    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
