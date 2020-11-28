package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;
import ingredient.Product;
import quantity.Quantity;
import quantity.Weight;
import tool.Kitchentool;
import tool.MixingCup;

import javax.sound.midi.Sequence;
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

    public Add(Kitchentool tool, Ingredient ingredients, Product product) {
        this.ingredient = ingredients;
        this.tool = tool;
        this.product = product;
        this.quantity = new Weight(10);
    }

    public Add(Kitchentool tool, Ingredient ingredients) {
        this.ingredient = ingredients;
        this.tool = tool;
    }

    @Override
    public Status execute() {
        if(this.product != null){
            ingredient.transform("used", true);
            System.out.println("added " + quantity.getAmount() + " of " + ingredient.getName() +
                    " to " + product.getName() + " in " + tool.getName());
            //todo: quantity zu product adden
            return Status.SUCCEEDED;
        }else{
            System.out.println("added " + ingredient.getName()+
                    " to " + tool.getName());
            return Status.SUCCEEDED;
        }

    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
