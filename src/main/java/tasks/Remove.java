package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;
import ingredient.Product;
import quantity.Quantity;
import tool.Kitchentool;
import tool.MixingCup;

import javax.sound.midi.Sequence;
import javax.tools.Tool;

public class Remove<Recipe> extends LeafTask<Recipe> {

    Kitchentool tool;
    Ingredient ingredient;


    public Remove(Kitchentool tool, Ingredient ingredients) {
        this.ingredient = ingredients;
        this.tool = tool;
    }

    @Override
    public Status execute() {
        System.out.println("Removed " + ingredient.getName()+
                " from " + tool.getName());
        return Status.SUCCEEDED;
    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
