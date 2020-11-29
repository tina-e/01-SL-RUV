package ingredient;

import config.Constants;
import quantity.Quantity;

public class LightBalsamico extends Ingredient{
    public LightBalsamico(){
        super(Constants.LIGHT_BALSAMICO);
    }
    public LightBalsamico(Quantity quantity){
        super(Constants.LIGHT_BALSAMICO, quantity);
    }
}
