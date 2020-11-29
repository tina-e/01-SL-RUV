package ingredient;

import config.Constants;
import quantity.Quantity;

public class RomaineLettuce extends Ingredient{
    public RomaineLettuce(){
        super(Constants.ROMAINELETTUCE);
    }
    public RomaineLettuce(Quantity quantity){
        super(Constants.ROMAINELETTUCE, quantity);
    }
}
