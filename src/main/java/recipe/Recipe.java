package recipe;

import behaviourtree.RecipeTree;
import ingredient.Ingredient;
import ingredient.Product;
import tool.Kitchentool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Recipe {

    String name;

    HashMap<String, Kitchentool> tools;
    HashMap<String, Ingredient> ingredients;
    RecipeTree instructions;

    Product product;

    public Recipe(String name){
        this.name = name;
        tools = new HashMap<>();
        ingredients = new HashMap<>();
        instructions = new RecipeTree();
        instructions.setObject(this);
    }

    public abstract void init();

    public RecipeTree getTree(){
        return instructions;
    }

    public void status(){
        Set<Map.Entry<String, Ingredient>> ingredientSet = ingredients.entrySet();
        for(Map.Entry<String, Ingredient> setEntry : ingredientSet){
            System.out.println(setEntry.getValue().getName() + " has used-status: " + setEntry.getValue().getTransformation("used"));
        }
    }
}
