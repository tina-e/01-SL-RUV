package recipe;

import com.badlogic.gdx.ai.btree.branch.Parallel;
import com.badlogic.gdx.ai.btree.branch.Sequence;
import config.Constants;
import ingredient.*;
import tasks.*;
import tool.Blender;
import tool.Grater;
import tool.MixingCup;

//todo: Mengenangaben s.quantity package

public class PestoRecipe extends Recipe{

    Sequence<Recipe> cookingTask;

    public PestoRecipe(String name) {
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
        tools.put(Constants.GRATER, new Grater());
        tools.put(Constants.MIXING_CUP, new MixingCup());
        tools.put(Constants.BLENDER, new Blender());
        ingredients.put(Constants.PARMESAN, new Parmesan());
        ingredients.put(Constants.LEMON_PEEL, new LemonPeel());
        ingredients.put(Constants.RAMSONS, new Ramsons());
        ingredients.put(Constants.PISTACHIO, new Pistachio());
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
                //todo: randoms daraus machen
                /*new Add<Recipe>(tools.get(Constants.MIXING_CUP),
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
