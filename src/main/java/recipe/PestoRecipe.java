package recipe;

import com.badlogic.gdx.ai.btree.branch.Parallel;
import com.badlogic.gdx.ai.btree.branch.RandomSequence;
import com.badlogic.gdx.ai.btree.branch.Sequence;
import com.badlogic.gdx.ai.btree.decorator.Invert;
import com.badlogic.gdx.ai.btree.decorator.UntilFail;
import com.badlogic.gdx.ai.btree.decorator.UntilSuccess;
import config.Constants;
import ingredient.*;
import quantity.Weight;
import tasks.*;
import tool.Blender;
import tool.Grater;
import tool.Jar;
import tool.MixingCup;

public class PestoRecipe extends Recipe{

    Sequence<Recipe> cookingTask;

    public PestoRecipe(String name) {
        super(name);
        product = new Product("RamsonsPesto");
        cookingTask = new Sequence<>();
    }

    @Override
    public void init() {
        populateMaps();
        instructions.addChild(buildSequence());
    }

    private void populateMaps(){
        tools.put(Constants.GRATER, new Grater());
        tools.put(Constants.MIXING_CUP, new MixingCup());
        tools.put(Constants.BLENDER, new Blender());
        tools.put(Constants.JAR, new Jar());
        ingredients.put(Constants.PARMESAN, new Parmesan(new Weight(75)));
        ingredients.put(Constants.LEMON_PEEL, new LemonPeel());
        ingredients.put(Constants.LEMON_JUICE, new LemonJuice(new Weight(1)));
        ingredients.put(Constants.RAMSONS, new Ramsons(new Weight(100)));
        ingredients.put(Constants.PISTACHIO, new Pistachio(new Weight(30)));
        ingredients.put(Constants.OLIVE_OIL, new OliveOil(new Weight(150)));
        ingredients.put(Constants.OLIVE_OIL + "1", new OliveOil());
        ingredients.put(Constants.SALT, new Salt());
        ingredients.put(Constants.PEPPER, new Pepper());
    }

    private Sequence<Recipe> buildSequence() {
        return new Sequence<>(
                buildPrepareSequence(),
                buildAddSequence(),
                buildBlendingSequence(),
                buildTasteTestSequence(),
                buildBottleSequence()
        );
    }

    private Parallel<Recipe> buildPrepareSequence() {
        return new Parallel<Recipe>(
                new Grate(ingredients.get(Constants.PARMESAN), (Grater) tools.get(Constants.GRATER)),
                new Grate(ingredients.get(Constants.LEMON_PEEL), (Grater) tools.get(Constants.GRATER)),
                buildRamsonsSequence()
        );
    }

    private Sequence<Recipe> buildRamsonsSequence() {
        Ramsons ramsons = (Ramsons) ingredients.get(Constants.RAMSONS);
        return new Sequence<Recipe>(
                new Wash(ramsons),
                new Dry(ramsons),
                new UntilSuccess(
                        new Pluck(ramsons)
                )
        );
    }

    private RandomSequence<Recipe> buildAddSequence() {
        MixingCup mixingCup = (MixingCup) tools.get(Constants.MIXING_CUP);
        return new RandomSequence<Recipe>(
                new Add(mixingCup, ingredients.get(Constants.PARMESAN), product),
                new Add(mixingCup, ingredients.get(Constants.LEMON_PEEL), product),
                new Add(mixingCup, ingredients.get(Constants.PISTACHIO), product),
                new Add(mixingCup, ingredients.get(Constants.OLIVE_OIL), product),
                new Add(mixingCup, ingredients.get(Constants.RAMSONS), product)
        );
    }

    private UntilSuccess<Recipe> buildBlendingSequence() {
        Blender blender = (Blender) tools.get(Constants.BLENDER);
        MixingCup mixingCup = (MixingCup) tools.get(Constants.MIXING_CUP);
        return new UntilSuccess<Recipe>(
                new Blend(blender, mixingCup, product)
        );
    }

    private RandomSequence<Recipe> buildTasteTestSequence() {
        MixingCup mixingCup = (MixingCup) tools.get(Constants.MIXING_CUP);
        return new RandomSequence<Recipe>(
                new UntilFail(
                        new Sequence(
                                new Invert(
                                        new TastesGood(product, ingredients.get(Constants.SALT))
                                ),
                                new Add(mixingCup, ingredients.get(Constants.SALT), product)
                        )
                ),
                new UntilFail(
                        new Sequence(
                                new Invert(
                                        new TastesGood(product, ingredients.get(Constants.PEPPER))
                                ),
                                new Add<>(mixingCup, ingredients.get(Constants.PEPPER), product)
                        )
                ),
                new Add<>(mixingCup, ingredients.get(Constants.LEMON_JUICE), product)
        );
    }

    private UntilFail<Recipe> buildBottleSequence() {
        return new UntilFail<Recipe>(
                new Sequence(
                        new IsStillAvailable(product),
                        new TakeJar((Jar) tools.get(Constants.JAR)),
                        new UntilFail(
                                new Sequence(
                                        new IsStillAvailable(product),
                                        new IsNotFull((Jar) tools.get(Constants.JAR)),
                                        new Bottle((Jar) tools.get(Constants.JAR), product)
                                )
                        ),
                        new PutOn(product, ingredients.get(Constants.OLIVE_OIL + "1"))
                )
        );
    }
}
