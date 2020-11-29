package ingredient;

import config.Constants;
import quantity.Quantity;

public class Pistachio extends Ingredient{

    public Pistachio(){
        super(Constants.PISTACHIO);
    }
    public Pistachio(Quantity quantity){
        super(Constants.PISTACHIO, quantity);
    }
}
