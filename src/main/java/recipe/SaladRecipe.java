package recipe;

import com.badlogic.gdx.ai.btree.branch.Parallel;
import com.badlogic.gdx.ai.btree.branch.RandomSequence;
import com.badlogic.gdx.ai.btree.branch.Sequence;
import com.badlogic.gdx.ai.btree.decorator.UntilSuccess;
import config.Constants;
import ingredient.*;
import quantity.BigSpoon;
import quantity.Weight;
import tasks.*;
import tool.Plate;

public class SaladRecipe extends Recipe{

    Sequence<Recipe> cookingTask;

    public SaladRecipe(String name) {
        super(name);
        product = new Product("Salad");
    }

    @Override
    public void init() {
        populateMaps();
        cookingTask = buildSequence();
        instructions.addChild(cookingTask);
    }

    private void populateMaps(){
        tools.put(Constants.PLATE, new Plate());
        ingredients.put(Constants.TOMATO, new Tomato(new Weight(800)));
        ingredients.put(Constants.NECTARINE, new Nectarine(new Weight(300)));
        ingredients.put(Constants.ARUGULA, new Arugula(new Weight(50)));
        ingredients.put(Constants.ROMAINELETTUCE, new RomaineLettuce(new Weight(200)));
        ingredients.put(Constants.BASIL, new Basil(new Weight(40)));
        ingredients.put(Constants.MOZZARELLA, new Mozzarella(new Weight(250)));
        ingredients.put(Constants.PARMA_HAM, new ParmaHam(new Weight(150)));
        ingredients.put(Constants.LIGHT_BALSAMICO, new LightBalsamico(new BigSpoon(6)));
        ingredients.put(Constants.OLIVE_OIL, new OliveOil(new BigSpoon(6)));
        ingredients.put(Constants.SALT, new Salt());
        ingredients.put(Constants.PEPPER, new Pepper());
    }

    private Sequence<Recipe> buildSequence() {
        return new Sequence(
            new RandomSequence(
                    new Sequence(
                            new Wash<>(ingredients.get(Constants.TOMATO)),
                            new Slice<>(ingredients.get(Constants.TOMATO))
                    ),
                    new Sequence(
                            new Wash<>(ingredients.get(Constants.NECTARINE)),
                            new Slice<>(ingredients.get(Constants.NECTARINE))
                    ),
                    new Sequence(
                            new Parallel(
                                    new Wash<>(ingredients.get(Constants.ARUGULA)),
                                    new Wash<>(ingredients.get(Constants.ROMAINELETTUCE))
                            ),
                            new UntilSuccess(
                                    new Sequence(
                                            new Dry(ingredients.get(Constants.ARUGULA)),
                                            new Dry(ingredients.get(Constants.ROMAINELETTUCE)),
                                            new IsDry(ingredients.get(Constants.ARUGULA)),
                                            new IsDry(ingredients.get(Constants.ROMAINELETTUCE))
                                    )
                            ),
                            new Slice<>(ingredients.get(Constants.ROMAINELETTUCE))
                    ),
                    new Sequence(
                            new Wash<>(ingredients.get(Constants.BASIL)),
                            new Pluck<>(ingredients.get(Constants.BASIL))
                    ),
                    new Pluck<>(ingredients.get(Constants.MOZZARELLA))
            ),
            new RandomSequence(
                    new Add<>(tools.get(Constants.PLATE), ingredients.get(Constants.MOZZARELLA),  product),
                    new Add<>(tools.get(Constants.PLATE), ingredients.get(Constants.BASIL),  product),
                    new Add<>(tools.get(Constants.PLATE), ingredients.get(Constants.ROMAINELETTUCE), product),
                    new Add<>(tools.get(Constants.PLATE), ingredients.get(Constants.ARUGULA), product),
                    new Add<>(tools.get(Constants.PLATE), ingredients.get(Constants.TOMATO), product),
                    new Add<>(tools.get(Constants.PLATE), ingredients.get(Constants.NECTARINE), product),
                    new Add<>(tools.get(Constants.PLATE), ingredients.get(Constants.PARMA_HAM),product)
            ),
            new RandomSequence(
                    new Add<>(tools.get(Constants.PLATE), ingredients.get(Constants.LIGHT_BALSAMICO), product),
                    new Add<>(tools.get(Constants.PLATE), ingredients.get(Constants.SALT), product),
                    new Add<>(tools.get(Constants.PLATE), ingredients.get(Constants.PEPPER), product),
                    new Add<>(tools.get(Constants.PLATE), ingredients.get(Constants.OLIVE_OIL), product)
            )
        );
    }
}
