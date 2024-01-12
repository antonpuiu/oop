import utils.AppUnitTask;
import utils.MainTask;
import utils.AppRunner;

public class App extends AppUnitTask {
    public static void main(String[] args) {
        AppRunner appRunner = new AppRunner() {
                @Override
                public MainTask[] getTasks() {
                    MainTask[] app = { new App() };

                    return app;
                }
            };

        appRunner.main();
    }

    @Override
    public MainTask[] getTasks() {
        MainTask[] tasks = {
            new lab1.Main(),
            new lab2.Main(),
            new lab3.Main(),
            new lab4.Main(),
            new lab5.Main(),
            new lab6.Main(),
            new lab7.Main(),
            new lab8.Main(),
            // new lab9.Main(),
            // new lab10.Main(),
            // new lab11.Main(),
            // new lab12.Main()
        };

        return tasks;
    }
}
