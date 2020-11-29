package ingredient;

import config.Constants;
import quantity.Quantity;

public class PumpkinSeeds extends Ingredient {
    public PumpkinSeeds(){
        super(Constants.PUMPKINSEEDS);
    }
    public PumpkinSeeds(Quantity quantity){
        super(Constants.PUMPKINSEEDS, quantity);
    }
}
