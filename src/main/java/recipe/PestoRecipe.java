package recipe;

import com.badlogic.gdx.ai.btree.branch.Parallel;
import com.badlogic.gdx.ai.btree.branch.Sequence;
import ingredient.LemonPeel;
import ingredient.Parmesan;
import tasks.Grate;
import tool.Grater;
import tool.Kitchentool;

public class PestoRecipe extends Recipe{

    Sequence<Recipe> cookingTask;

    public PestoRecipe(String name) {
        super(name);
        cookingTask = new Sequence<>();
    }

    @Override
    public void init() {
        populateMaps();
        Parallel<Recipe> prepareTask = new Parallel<>();
        prepareTask.addChild(new Grate<Recipe>(ingredients.get("Parmesan"), (Grater) tools.get("Grater")));
        prepareTask.addChild(new Grate<Recipe>(ingredients.get("LemonPeel"), (Grater) tools.get("Grater")));
        cookingTask.addChild(prepareTask);
        instructions.addChild(cookingTask);
    }

    private void populateMaps(){
        tools.put("Grater", new Grater());
        ingredients.put("Parmesan", new Parmesan());
        ingredients.put("LemonPeel", new LemonPeel());
    }
}
