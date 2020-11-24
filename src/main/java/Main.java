import behaviourtree.RecipeTree;
import com.badlogic.gdx.ai.btree.Task;
import recipe.SaladRecipe;
import tasks.Prepare;
import recipe.PestoRecipe;
import recipe.Recipe;

public class Main {

    public static void main(String[] args) {
        //Recipe myRecipe = new PestoRecipe("Pesto");
        Recipe myRecipe = new SaladRecipe("Salad");
        //Recipe myRecipe = new ZucPestoRecipe("Zuchini-Pesto");

        myRecipe.init();
        RecipeTree<Recipe> recipeTree = myRecipe.getTree();

        do{
            recipeTree.step();
            System.out.println("tree status: " + recipeTree.getStatus());
        }
        while (recipeTree.getStatus() == Task.Status.RUNNING);
    }
}
