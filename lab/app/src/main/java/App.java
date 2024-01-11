import utils.*;

public class App extends Runner {
    public static void main(String[] args) {
        new App().main();
    }

    @Override
    public MainTask[] getTasks() {
        MainTask[] tasks = {
            new lab1.Main(),
            new lab2.Main(),
            new lab3.Main(),
            new lab4.Main(),
            new lab5.Main(),
            // new lab6.Main(),
            // new lab7.Main(),
            // new lab8.Main(),
            // new lab9.Main(),
            // new lab10.Main(),
            // new lab11.Main(),
            // new lab12.Main()
        };

        return tasks;
    }

    @Override
    public String getUnit() {
        return "lab";
    }

    @Override
    public int getId() {
        return 0;
    }
}
