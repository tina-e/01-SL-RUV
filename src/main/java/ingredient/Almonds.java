package ingredient;

import config.Constants;
import quantity.Quantity;

public class Almonds extends Ingredient {
    public Almonds(){
        super(Constants.ALMONDS);
    }

    public Almonds(Quantity quantity){
        super(Constants.ALMONDS, quantity);
    }
}
