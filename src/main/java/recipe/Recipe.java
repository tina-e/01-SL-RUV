package recipe;

import behaviourtree.RecipeTree;
import ingredient.Ingredient;
import ingredient.PineNuts;
import preparation.Roasting;
import tool.Kitchentool;
import tool.Pan;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Recipe {

    String name;
    HashMap<String, Kitchentool> tools;
    HashMap<String, Ingredient> ingredients;
    RecipeTree instructions;

    public Recipe(String name){
        this.name = name;
        tools = new HashMap<>();
        ingredients = new HashMap<>();
        instructions = new RecipeTree();
        instructions.setObject(this);
    }

    public void init(){
        Ingredient i = new PineNuts();
        Kitchentool t = new Pan();
        instructions.addChild(new Roasting(i,t));
    }

    public void addIngredient(Ingredient newIngredient){
        ingredients.put(newIngredient.getName(), newIngredient);
    }

    public Ingredient findIngredient(String ingredientString){
        return ingredients.get(ingredientString);
    }

    public RecipeTree getTree(){
        return instructions;
    }

    public void status(){
        Set<Map.Entry<String, Ingredient>> ingredientSet = ingredients.entrySet();

        for(Map.Entry<String, Ingredient> setEntry : ingredientSet){
            System.out.println(setEntry.getValue().getName() + " has used-status: " + setEntry.getValue().isUsed());
        }
    }
}
