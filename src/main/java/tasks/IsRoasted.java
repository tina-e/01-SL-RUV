package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;

public class IsRoasted extends LeafTask {
    Ingredient ingredient;
    public IsRoasted(Ingredient ingredient){
        this.ingredient = ingredient;
    }

    @Override
    public Status execute() {
        if(this.ingredient.getTransformation("roasted")){
            System.out.println(ingredient.getName() + " is roasted");
            return Status.SUCCEEDED;
        }
        System.out.println(ingredient.getName() + " is not roasted");
        return Status.FAILED;
    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
