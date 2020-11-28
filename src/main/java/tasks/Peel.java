package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;

import javax.sound.midi.Sequence;

public class Peel extends LeafTask {
    private Ingredient ingredient;
    public Peel(Ingredient ingredient){
        this.ingredient = ingredient;
    }
    @Override
    public Status execute() {
        ingredient.transform("peeled", true);
        System.out.println(ingredient.getName() + " got peeled");
        return Status.SUCCEEDED;
    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
