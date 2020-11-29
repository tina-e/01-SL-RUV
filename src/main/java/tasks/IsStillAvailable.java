package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;

public class IsStillAvailable extends LeafTask {

    Ingredient ingredient;

    public IsStillAvailable(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public Status execute() {
        //System.out.println("Checking status of ingredient" + ingredient.getTransformation("used"));
        //return (ingredient.getTransformation("used")) ? Status.FAILED : Status.SUCCEEDED;
        if(ingredient.getTransformation("used") == false){
            System.out.println("Failing task");
            return Status.SUCCEEDED;
        }else{
            return Status.FAILED;
        }
    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
