package lab5.task2;

import lab5.task1.Task;

public class Queue extends ListContainer {
    public Queue() {
        super();
    }

    @Override
    public Task pop() {
        Task task;
        int last = tasks.size() - 1;

        task = tasks.get(last);
        tasks.remove(last);

        return task;
    }

    @Override
    public void push(Task task) {
        tasks.add(0, task);
    }
}
