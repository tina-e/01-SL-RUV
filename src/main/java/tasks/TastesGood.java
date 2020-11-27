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

    public TastesGood(Product product){
        this.product = product;
    }

    public Status execute() {
        Scanner s = new Scanner(System.in);
        System.out.print("Willst du noch abschmecken: (j/n): ");
        String input = s.nextLine();
        if (input.startsWith("j")) {
            product.transform("tastesGood", false);
            return Status.FAILED;
        }
        product.transform("tastesGood", true);
        return Status.SUCCEEDED;
    }

    protected Task copyTo(Task task) {
        return null;
    }
}
