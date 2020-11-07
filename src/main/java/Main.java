import behaviourtree.RecipeTree;
import com.badlogic.gdx.ai.btree.Task;
import preparation.TestTask;
import recipe.Recipe;

public class Main {

    public static void main(String[] args) {
        Recipe myRecipe = new Recipe("Pesto");
        RecipeTree<Recipe> recipeTree = new RecipeTree<>();
        recipeTree.setObject(myRecipe);

        recipeTree.addChild(new TestTask<>());
        recipeTree.step();

        do{
            recipeTree.step();
            System.out.println("tree status: " + recipeTree.getStatus());
        }
        while (recipeTree.getStatus() == Task.Status.RUNNING);
    }
}
