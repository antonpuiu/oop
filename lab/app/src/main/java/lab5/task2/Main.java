package lab5.task2;

import lab5.task1.Task;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        System.out.println("----> Queue");

        Queue q = new Queue();

        for(Task task : lab5.task1.Main.tasks)
            q.push(task);

        q.pop();
        q.pop();

        for (Task task : q.getTasks())
            task.execute();

        System.out.println("----> Stack");

        Stack s = new Stack();

        for(Task task : lab5.task1.Main.tasks)
            s.push(task);

        s.pop();
        s.pop();

        for (Task task : s.getTasks())
            task.execute();

        System.out.println("----> Testing transferFrom");
        q.transferFrom(s);

        for (Task task : q.getTasks())
            task.execute();

        // This should print true
        System.out.println(s.isEmpty());
    }

    @Override
    public int getId() {
        return 2;
    }
}
