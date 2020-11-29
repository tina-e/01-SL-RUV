package ingredient;

import quantity.Quantity;
import quantity.Weight;

import java.util.HashMap;

public abstract class Ingredient {
    protected String name;
    protected Quantity quantity;
    protected HashMap<String, Boolean> transformation;

    public Ingredient(String n){
        this(n, new Weight());
    }

    public Ingredient(String n, Quantity q){
        name = n;
        quantity = q;
        transformation = new HashMap<String, Boolean>();
        transformation.put("used", Boolean.FALSE);
    }

    public String getName(){
        return name;
    }

    public Boolean getTransformation(String action) {
        return transformation.getOrDefault(action, null);
    }

    public void transform(String action, boolean status){
        transformation.put(action, status);
    }

    public Quantity getQuantity() {
        return quantity;
    }
}
