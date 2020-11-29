package recipe;

import com.badlogic.gdx.ai.btree.branch.Parallel;
import com.badlogic.gdx.ai.btree.branch.RandomSequence;
import com.badlogic.gdx.ai.btree.branch.Selector;
import com.badlogic.gdx.ai.btree.branch.Sequence;
import com.badlogic.gdx.ai.btree.decorator.Invert;
import com.badlogic.gdx.ai.btree.decorator.UntilFail;
import com.badlogic.gdx.ai.btree.decorator.UntilSuccess;
import config.Constants;
import ingredient.*;
import quantity.BigSpoon;
import quantity.Quantity;
import quantity.Weight;
import tasks.*;
import tool.Blender;
import tool.Grater;
import tool.Jar;
import tool.MixingCup;


//todo: Mengenangaben s.quantity package

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
        //cookingTask.addChild(new Season<>(ingredients.get(Constants.SALT), ingredients.get(Constants.PEPPER)));
        instructions.addChild(buildSequence());
    }

    private void populateMaps(){
        tools.put(Constants.GRATER, new Grater());
        tools.put(Constants.MIXING_CUP, new MixingCup());
        tools.put(Constants.BLENDER, new Blender());
        tools.put(Constants.JAR, new Jar());
        ingredients.put(Constants.PARMESAN, new Parmesan(new Weight(75)));
        ingredients.put(Constants.LEMON_PEEL, new LemonPeel());
        ingredients.put(Constants.LEMON_JUICE, new LemonJuice());
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
        return new Parallel(
                new Grate(ingredients.get(Constants.PARMESAN), (Grater) tools.get(Constants.GRATER)),
                new Grate(ingredients.get(Constants.LEMON_PEEL), (Grater) tools.get(Constants.GRATER)),
                buildRamsonsSequence()
        );
    }

    private Sequence buildRamsonsSequence() {
        Ramsons ramsons = (Ramsons) ingredients.get(Constants.RAMSONS);
        return new Sequence(
                new Wash(ramsons),
                new Dry(ramsons),
                new UntilSuccess(
                        //todo: quantity
                        new Pluck(ramsons, 80)
                )
        );
    }

    private RandomSequence<Recipe> buildAddSequence() {
        MixingCup mixingCup = (MixingCup) tools.get(Constants.MIXING_CUP);
        //todo: quantity and product
        return new RandomSequence(
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
        return new UntilSuccess(
                new Blend(blender, mixingCup, product)
        );
    }

    private UntilSuccess<Recipe> buildTasteTestSequence() {
        MixingCup mixingCup = (MixingCup) tools.get(Constants.MIXING_CUP);
        return new UntilSuccess<Recipe>(
                new Sequence<Recipe>(
                        new Invert<Recipe>(
                                new TastesGood(product)
                        ),
                        new RandomSequence(
                                new Add<>(mixingCup, ingredients.get(Constants.SALT), product),
                                new Add<>(mixingCup, ingredients.get(Constants.LEMON_JUICE), product),
                                new Add<>(mixingCup, ingredients.get(Constants.PEPPER), product)
                        )
                )
        );
    }

    private UntilFail<Recipe> buildBottleSequence() {
        int requiredJars = (int) Math.ceil(product.getAmount() / Jar.TOTAL_SPACE);
        Sequence sequence = new Sequence();
        for (int i = 0; i < requiredJars; i++) {
            tools.put(Constants.JAR + i, new Jar(Constants.JAR + i));
            sequence.addChild(buildJarSequence(i));
        }
        return new UntilFail(
                new Sequence(
                        new IsStillAvailable(product),
                        sequence
                )
        );
    }

    private Sequence buildJarSequence(int jarKey) {
        return new Sequence(
                new UntilFail(
                        new Selector(
                                new IsNotFull((Jar) tools.get(Constants.JAR + jarKey)),
                                new Bottle((Jar) tools.get(Constants.JAR + jarKey), product)
                        )
                ),
                new PutOn(product, ingredients.get(Constants.OLIVE_OIL + "1"))
        );
    }
}
