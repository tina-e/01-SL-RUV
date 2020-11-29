package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import ingredient.Product;
import tool.Jar;

public class Debug extends LeafTask {
    private String msg;
    private Product prod;
    public Debug(String msg){
        this.msg= msg;
    }

    public Debug(Product prod) {
        this.prod = prod;
    }

    @Override
    public Status execute() {
        if(msg == null){
            System.out.println(prod.getAmount());
            return Status.FAILED;
        }
        System.out.println(msg);
        return Status.FAILED;
    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
