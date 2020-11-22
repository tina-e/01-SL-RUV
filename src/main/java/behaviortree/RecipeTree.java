package behaviortree;

import com.badlogic.gdx.ai.btree.BehaviorTree;

public class RecipeTree extends BehaviorTree {
    BehaviorTree tree;
    String name;
    public RecipeTree(String name, BehaviorTree tree){
        this.name = name;
        this.tree = tree;
        if(tree != null) tree.setObject(this);
    }
}
