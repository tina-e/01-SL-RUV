package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;
import ingredient.Product;
import recipe.Recipe;

import java.util.Scanner;

public class TastesGood extends LeafTask {
    public String amount;
    private Product product;
    private Ingredient ingredient;

    public TastesGood(Product product, Ingredient ingredient){
        this.product = product;
        this.ingredient = ingredient;
    }

    public Status execute() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enough " + ingredient.getName() + "?: (y/n): ");
        String input = s.nextLine();
        if (input.startsWith("y")) {
            product.transform("tastesGood", true);
            return Status.SUCCEEDED;
        }
        product.transform("tastesGood", false);
        return Status.FAILED;
    }

    protected Task copyTo(Task task) {
        return null;
    }
}
