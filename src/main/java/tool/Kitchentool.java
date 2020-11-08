package tool;

public abstract class Kitchentool {
    protected String name;

    public Kitchentool(String n){
        name = n;
    }

    public String getName(){
        return name;
    }
}
