package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;
import tool.Kitchentool;

import java.util.ArrayList;

public class Roasting<Rezept> extends LeafTask<Rezept> {
    Ingredient ingredient;
    Kitchentool tool;

    public Roasting(Ingredient ingredient, Kitchentool kitchentool){
        this.tool = kitchentool;
        this.ingredient = ingredient;
    }
    public Status execute(){
        ingredient.transform("roasted", true);
        System.out.println(ingredient.getName() +" has been roasted in " + tool.getName());
        return Status.SUCCEEDED;
    }

    protected Task<Rezept> copyTo (Task<Rezept> task){
        return null;
    }
}
