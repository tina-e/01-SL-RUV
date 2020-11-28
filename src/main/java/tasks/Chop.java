package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Ingredient;

import javax.sound.midi.Sequence;

public class Chop extends LeafTask {
    private Ingredient ingredient;
    private String howToChop;
    public Chop(Ingredient ingredient, String howToChop) {
        this.ingredient = ingredient;
        this.howToChop = howToChop;
    }

    @Override
    public Status execute() {
        System.out.println("chopping " + ingredient.getName() + " in the form of : "+howToChop);
        ingredient.transform("chopped", true);
        return Status.SUCCEEDED;
    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
