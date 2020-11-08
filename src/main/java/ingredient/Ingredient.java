package ingredient;

public abstract class Ingredient {
    protected String name;
    protected boolean used;

    public Ingredient(){
        used = false;
    }
    public Ingredient(String n){
        used = false;
        name = n;
    }

    public String getName(){
        return name;
    }

    public boolean isUsed(){
        return used;
    }

    public void use(){
        used = true;
    }
}
