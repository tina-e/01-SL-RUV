package recipe;

import com.badlogic.gdx.ai.btree.branch.Parallel;
import com.badlogic.gdx.ai.btree.branch.Sequence;
import config.Constants;
import ingredient.*;
import tasks.*;

//import tool.Blender;
/*import tool.Blender;
import tool.MixingCup;*/

import tool.*;


//todo: an rezept anpassen + mengen nicht vergessen

public class ZucPestoRecipe extends Recipe {

    Sequence<Recipe> cookingTask;

    public ZucPestoRecipe(String name) {
        super(name);
        product = new Product("Zuccini Pesto");
        cookingTask = new Sequence<>();
    }

    @Override
    public void init() {
        populateMaps();
        //cookingTask.addChild(buildPrepareSequence());
        //cookingTask.addChild(buildBlendingSequence());
        //cookingTask.addChild(new Season<>(ingredients.get(Constants.SALT), ingredients.get(Constants.PEPPER)));
        instructions.addChild(new Dry(ingredients.get(Constants.ALMONDS)));
        //instructions.addChild(cookingTask);
    }

    private void populateMaps() {
        Blender ble = new Blender();
        Grater grater = new Grater();


        Pan pan = new Pan();
        //tools.put(Constants.PAN, pan);
        /*tools.put(Constants.MIXING_CUP, new MixingCup());
        tools.put(Constants.BLENDER, new Blender());

        ingredients.put(Constants.ALMONDS, new Almonds());
        ingredients.put(Constants.PUMPKINSEEDS, new PumpkinSeeds());
        ingredients.put(Constants.GARLICCLOVE, new GarlicClove());
        ingredients.put(Constants.PARMESAN, new Parmesan());
        ingredients.put(Constants.ZUCCHINI, new Zucchini());
        ingredients.put(Constants.BASIL, new Basil());
        ingredients.put(Constants.OLIVE_OIL, new OliveOil());
        ingredients.put(Constants.SALT, new Salt());
        ingredients.put(Constants.PEPPER, new Pepper());
        */
        ingredients.put(Constants.ALMONDS, new Almonds());
    }

}