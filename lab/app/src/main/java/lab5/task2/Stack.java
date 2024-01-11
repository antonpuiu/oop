package lab5.task2;

import lab5.task1.Task;

public class Stack extends ListContainer {
    public Stack() {
        super();
    }

    @Override
    public Task pop() {
        Task task = tasks.get(0);

        tasks.remove(0);

        return task;
    }

    @Override
    public void push(Task task) {
        tasks.add(0, task);
    }
}
