package ingredient;

import config.Constants;
import quantity.Quantity;

public class Zucchini extends Ingredient {
    public Zucchini(){
        super(Constants.ZUCCHINI);
    }
    public Zucchini(Quantity quantity){
        super(Constants.ZUCCHINI, quantity);
    }
}
