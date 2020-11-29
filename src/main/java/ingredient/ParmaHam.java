package ingredient;

import config.Constants;
import quantity.Quantity;

public class ParmaHam extends Ingredient{
    public ParmaHam(){
        super(Constants.PARMA_HAM);
    }
    public ParmaHam(Quantity quantity){
        super(Constants.PARMA_HAM, quantity);
    }
}
