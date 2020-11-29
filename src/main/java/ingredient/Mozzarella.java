package ingredient;

import config.Constants;
import quantity.Quantity;

public class Mozzarella extends Ingredient{
    public Mozzarella(){
        super(Constants.MOZZARELLA);
    }
    public Mozzarella(Quantity quantity){
        super(Constants.MOZZARELLA, quantity);
    }
}
