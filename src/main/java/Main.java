import behaviourtree.RecipeTree;
import com.badlogic.gdx.ai.btree.Task;
import recipe.SaladRecipe;
import recipe.ZucPestoRecipe;
import tasks.Prepare;
import recipe.PestoRecipe;
import recipe.Recipe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Recipe myRecipe;
        Scanner s = new Scanner(System.in);
        System.out.println("Which Recipe shall we cook? 1: RamsonsPesto; 2: NectarineSalad; 3: ZucchiniPesto");
        String input = s.nextLine();
        switch (input) {
            case "1": default:
                myRecipe = new PestoRecipe("Pesto");
                break;
            case "2":
                myRecipe = new SaladRecipe("Salad");
                break;
            case "3":
                myRecipe = new ZucPestoRecipe("Zucchini-Pesto");
                break;
        }
        myRecipe.init();
        RecipeTree<Recipe> recipeTree = myRecipe.getTree();
        do{
            recipeTree.step();
            System.out.println("tree status: " + recipeTree.getStatus());
        }
        while (recipeTree.getStatus() == Task.Status.RUNNING);
        System.out.println("Finished Cooking!");
    }
}
