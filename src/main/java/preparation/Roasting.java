package preparation;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;
import tool.Kitchentool;

import java.util.ArrayList;

public class Roasting<Rezept> extends LeafTask<Rezept> {
    ArrayList<Ingredient> ingredients;
    Kitchentool tool;

    public Roasting(Ingredient i, Kitchentool t){
        super();
        tool = t;
        ingredients = new ArrayList<>();
        ingredients.add(i);
    }
    public Status execute(){
        return Status.SUCCEEDED;
    }

    protected Task<Rezept> copyTo (Task<Rezept> task){
        return null;
    }
}
