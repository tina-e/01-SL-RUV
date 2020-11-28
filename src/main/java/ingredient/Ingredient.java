package ingredient;

import java.util.HashMap;

public abstract class Ingredient {
    protected String name;
    protected HashMap<String, Boolean> transformation;

    //todo: evtl used rauslöschen

    public Ingredient(){
        transformation = new HashMap<String, Boolean>();
        transformation.put("used", Boolean.FALSE);
    }
    public Ingredient(String n){
        name = n;
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
        if (transformation.containsKey(action)) {
            System.out.println(action + " already applied on " + name);
        } else {
            transformation.put(action, status);
        }
    }
}
