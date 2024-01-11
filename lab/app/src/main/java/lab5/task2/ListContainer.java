package lab5.task2;

import java.util.ArrayList;

import lab5.task1.Task;

public abstract class ListContainer implements Container {
    protected ArrayList<Task> tasks;

    public ListContainer() {
        tasks = new ArrayList<Task>();
    }

    @Override
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @Override
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    @Override
    public int size() {
        return tasks.size();
    }

    @Override
    public void transferFrom(Container container) {
        while (!container.isEmpty())
            tasks.add(0, container.pop());
    }
}
