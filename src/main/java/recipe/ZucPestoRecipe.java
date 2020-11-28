package recipe;

import com.badlogic.gdx.ai.btree.branch.Parallel;
import com.badlogic.gdx.ai.btree.branch.RandomSequence;
import com.badlogic.gdx.ai.btree.branch.Selector;
import com.badlogic.gdx.ai.btree.branch.Sequence;
import com.badlogic.gdx.ai.btree.decorator.UntilSuccess;
import config.Constants;
import ingredient.*;
import quantity.BigSpoon;
import quantity.Quantity;
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
        cookingTask.addChild(buildPrepareSequence());
        buildRestSequence();
        instructions.addChild(cookingTask);
    }

    private void populateMaps() {
        tools.put(Constants.MIXING_CUP, new MixingCup());
        tools.put(Constants.BLENDER, new Blender());
        tools.put(Constants.PAN, new Pan());
        tools.put(Constants.JAR, new Jar());

        ingredients.put(Constants.ALMONDS, new Almonds());
        ingredients.put(Constants.PUMPKINSEEDS, new PumpkinSeeds());
        ingredients.put(Constants.GARLICCLOVE, new GarlicClove());
        ingredients.put(Constants.PARMESAN, new Parmesan());
        ingredients.put(Constants.ZUCCHINI, new Zucchini());
        ingredients.put(Constants.BASIL, new Basil());
        ingredients.put(Constants.OLIVE_OIL, new OliveOil());
        ingredients.put(Constants.SALT, new Salt());
        ingredients.put(Constants.PEPPER, new Pepper());
    }

    private Parallel<Recipe> buildPrepareSequence() {
        Parallel<Recipe> prepareTask = new Parallel<>();

        Sequence<Recipe> washAndCut = new Sequence<>(getSeqWashAndDry(), getRSeqCutting());

        Sequence<Recipe> roast = getSeqRoast();
        prepareTask.addChild(washAndCut);
        prepareTask.addChild(roast);
        return prepareTask;
    }

    private void buildRestSequence(){
        RandomSequence<Recipe> addToMixing = new RandomSequence<>();
        addToMixing.addChild(new Add(tools.get(Constants.MIXING_CUP),ingredients.get(Constants.GARLICCLOVE)));
        addToMixing.addChild(new Add(tools.get(Constants.MIXING_CUP),ingredients.get(Constants.ZUCCHINI)));
        addToMixing.addChild(new Add(tools.get(Constants.MIXING_CUP),ingredients.get(Constants.BASIL)));
        addToMixing.addChild(new Add(tools.get(Constants.MIXING_CUP),ingredients.get(Constants.PARMESAN)));
        addToMixing.addChild(new Add(tools.get(Constants.MIXING_CUP),ingredients.get(Constants.ALMONDS)));
        addToMixing.addChild(new Add(tools.get(Constants.MIXING_CUP),ingredients.get(Constants.PUMPKINSEEDS)));
        addToMixing.addChild(new Add(tools.get(Constants.MIXING_CUP),ingredients.get(Constants.OLIVE_OIL) )); //TODO add 250 mil stuff
        cookingTask.addChild(addToMixing);
        cookingTask.addChild(new Blend<Recipe>((Blender) tools.get(Constants.BLENDER), ingredients.get(Constants.GARLICCLOVE),ingredients.get(Constants.ZUCCHINI),ingredients.get(Constants.BASIL),ingredients.get(Constants.PARMESAN),ingredients.get(Constants.ALMONDS),ingredients.get(Constants.PUMPKINSEEDS),ingredients.get(Constants.OLIVE_OIL)));
        cookingTask.addChild(new Selector<>(new TastesGood(product), new Sequence<>(new Season(ingredients.get(Constants.SALT), product), new Season(ingredients.get(Constants.PEPPER), product))));
        cookingTask.addChild(new Sequence<Recipe>(new Add<Recipe>(tools.get(Constants.JAR), product), new Arrange(product, "flat"),new Add<Recipe>(tools.get(Constants.JAR), ingredients.get(Constants.OLIVE_OIL),new BigSpoon(1), product)));

        cookingTask.addChild(new Store(product, "chill and dry"));
    }

    private Sequence<Recipe> getSeqWashAndDry(){
        Sequence sequence = new Sequence();
        sequence.addChild(new Peel(ingredients.get(Constants.GARLICCLOVE)));
        sequence.addChild(new Wash(ingredients.get(Constants.ZUCCHINI)));
        sequence.addChild(new Wash(ingredients.get(Constants.BASIL)));
        UntilSuccess<Recipe> dryBasil = new UntilSuccess<>(new Sequence<>(new Dry<>(ingredients.get(Constants.BASIL)), new IsDry(ingredients.get(Constants.BASIL))));
        sequence.addChild(dryBasil);
        return sequence;
    }

    private RandomSequence<Recipe> getRSeqCutting(){
        RandomSequence sequence = new RandomSequence();
        sequence.addChild(new Chop(ingredients.get(Constants.GARLICCLOVE), "diced"));
        sequence.addChild(new Chop(ingredients.get(Constants.PARMESAN), "diced"));
        sequence.addChild(new Chop(ingredients.get(Constants.ZUCCHINI), "diced"));
        Sequence<Recipe> basil = new Sequence<>(new Dry<>(ingredients.get(Constants.BASIL)), new Pluck<>(ingredients.get(Constants.BASIL), 100));
        sequence.addChild(basil);
        return sequence;
    }
    private Sequence<Recipe> getSeqRoast(){
        Sequence sequence = new Sequence();
        sequence.addChild(new Add(tools.get(Constants.PAN),ingredients.get(Constants.ALMONDS)));
        sequence.addChild(new Add(tools.get(Constants.PAN),ingredients.get(Constants.PUMPKINSEEDS)));

        UntilSuccess success = new UntilSuccess(new Sequence(new Roasting(ingredients.get(Constants.ALMONDS),tools.get(Constants.PAN)),new Roasting(ingredients.get(Constants.PUMPKINSEEDS),tools.get(Constants.PAN)), new IsRoasted(ingredients.get(Constants.ALMONDS)),new IsRoasted(ingredients.get(Constants.PUMPKINSEEDS))));
        sequence.addChild(success);
        sequence.addChild(new Remove(tools.get(Constants.PAN),ingredients.get(Constants.PUMPKINSEEDS)));
        sequence.addChild(new Remove(tools.get(Constants.PAN),ingredients.get(Constants.ALMONDS)));
        return sequence;
    }

}