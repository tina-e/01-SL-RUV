package ingredient;

import config.Constants;
import quantity.Quantity;

public class Parmesan extends Ingredient {

    public Parmesan(){
        super(Constants.PARMESAN);
    }
    public Parmesan(Quantity quantity){
        super(Constants.PARMESAN, quantity);
    }
}
