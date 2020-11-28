package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;
import ingredient.Product;

import javax.sound.midi.Sequence;

public class Arrange extends LeafTask {
    private Product product;
    private String howToArrange;
    public Arrange(Product product, String howToArrange) {
        this.product = product;
        this.howToArrange = howToArrange;
    }

    @Override
    public Status execute() {
        System.out.println("arranging " + product.getName() + " in the form of : "+ howToArrange);
        product.transform("arranging ", true);
        return Status.SUCCEEDED;
    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
