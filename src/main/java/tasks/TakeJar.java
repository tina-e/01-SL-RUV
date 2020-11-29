package tasks;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import tool.Jar;

public class TakeJar extends LeafTask {

    private Jar jar;

    public TakeJar(Jar jar) {
        this.jar = jar;
    }

    @Override
    public Status execute() {
        jar.resetSpace();
        System.out.println("new jar was taken");
        return Status.SUCCEEDED;
    }

    @Override
    protected Task copyTo(Task task) {
        return null;
    }
}
