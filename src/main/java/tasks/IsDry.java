package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;

public class IsDry extends LeafTask {
    Ingredient ingredient;
    public IsDry(Ingredient ingredient){
        this.ingredient = ingredient;
    }

    @Override
    public Status execute() {
        if(ingredient.getTransformation("dry")){
            System.out.println(ingredient.getName() + " is dry");
            return Status.SUCCEEDED;
        }
        System.out.println(ingredient.getName() + " is not dry");
        return Status.FAILED;
    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
