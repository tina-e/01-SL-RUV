package recipe;

import com.badlogic.gdx.ai.btree.branch.Parallel;
import com.badlogic.gdx.ai.btree.branch.Sequence;
import config.Constants;
import ingredient.*;
import tasks.*;
import tool.Blender;
import tool.Grater;
import tool.MixingCup;
import tool.Plate;

//todo: an rezept anpassen + mengen nicht vergessen

public class SaladRecipe extends Recipe{

    Sequence<Recipe> cookingTask;

    public SaladRecipe(String name) {
        super(name);
        cookingTask = new Sequence<>();
    }

    @Override
    public void init() {
        populateMaps();
        cookingTask.addChild(buildPrepareSequence());
        cookingTask.addChild(buildBlendingSequence());
        cookingTask.addChild(new Season<>(ingredients.get(Constants.SALT), ingredients.get(Constants.PEPPER)));
        instructions.addChild(cookingTask);
    }

    private void populateMaps(){
        tools.put(Constants.PLATE, new Plate());
        ingredients.put(Constants.TOMATO, new Tomato());
        ingredients.put(Constants.NECTARINE, new Nectarine());
        ingredients.put(Constants.ROMAINELETTUCE, new RomaineLettuce());
        ingredients.put(Constants.BASIL, new Basil());
        ingredients.put(Constants.MOZZARELLA, new Mozzarella());
        ingredients.put(Constants.PARMA_HAM, new ParmaHam());
        ingredients.put(Constants.LIGHT_BALSAMICO, new LightBalsamico());
        ingredients.put(Constants.OLIVE_OIL, new OliveOil());
        ingredients.put(Constants.SALT, new Salt());
        ingredients.put(Constants.PEPPER, new Pepper());
    }

    private Parallel<Recipe> buildPrepareSequence() {
        Parallel<Recipe> prepareTask = new Parallel<>();
        prepareTask.addChild(new Grate<Recipe>(ingredients.get(Constants.PARMESAN), (Grater) tools.get(Constants.GRATER)));
        prepareTask.addChild(new Grate<Recipe>(ingredients.get(Constants.LEMON_PEEL), (Grater) tools.get(Constants.GRATER)));
        Ingredient ramsons = ingredients.get(Constants.RAMSONS);
        Sequence<Recipe> ramsonsSequence = new Sequence<>(
                new Clean<>(ramsons),
                new Dry<>(ramsons),
                new Pluck<>(ramsons, 80));
        prepareTask.addChild(ramsonsSequence);
        return prepareTask;
    }

    private Sequence<Recipe> buildBlendingSequence() {
        return new Sequence<>();
        /*
                new Add<Recipe>((MixingCup) tools.get(Constants.MIXING_CUP),
                        ingredients.get(Constants.RAMSONS),
                        ingredients.get(Constants.PARMESAN),
                        ingredients.get(Constants.LEMON_PEEL),
                        ingredients.get(Constants.PISTACHIO),
                        ingredients.get(Constants.OLIVE_OIL)),
                new Blend<Recipe>((Blender) tools.get(Constants.BLENDER),
                        ingredients.get(Constants.RAMSONS),
                        ingredients.get(Constants.PARMESAN),
                        ingredients.get(Constants.LEMON_PEEL),
                        ingredients.get(Constants.PISTACHIO),
                        ingredients.get(Constants.OLIVE_OIL)));*/
    }
}
