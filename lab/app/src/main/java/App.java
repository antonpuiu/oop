import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import utils.AppRunner;
import utils.AppUnitTask;
import utils.MainTask;

public class App extends AppUnitTask {
    private static void simpleApp() {
        Display display = new Display();
        Shell shell = new Shell(display);

        // the layout manager handle the layout
        // of the widgets in the container
        shell.setLayout(new FillLayout());

        Label label = new Label(shell, SWT.BORDER);
        label.setText("This is a label:");
        label.setToolTipText("This is the tooltip of this label");

        // Text text = new Text(shell, SWT.NONE);
        // text.setText("This is the text in the text widget");
        // text.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
        // text.setForeground(display.getSystemColor(SWT.COLOR_WHITE));

        // set widgets size to their preferred size
        // text.pack();
        label.pack();
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        display.dispose();
    }

    private static void browserApp() {
        Display display = new Display();
        Shell shell = new Shell(display);

        // the layout manager handle the layout
        // of the widgets in the container
        shell.setLayout(new FillLayout());

        Browser browser = new Browser(shell, SWT.NONE);
        browser.setUrl("http://google.com");

        // set widgets size to their preferred size
        browser.pack();
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        display.dispose();
    }

    private static void defaultSWT() {
        Display display = new Display();
        Shell shell = new Shell(display);

        // the layout manager handle the layout
        // of the widgets in the container
        shell.setLayout(new FillLayout());

        // set widgets size to their preferred size
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        display.dispose();
    }

    private static void labApp() {
        AppRunner appRunner = new AppRunner() {
                @Override
                public MainTask[] getTasks() {
                    MainTask[] app = { new App() };

                    return app;
                }
            };

        appRunner.main();
    }

    public static void main(String[] args) {
        labApp();
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
            new lab9.Main(),
            new lab10.Main(),
            new lab11.Main(),
            new lab12.Main()
        };

        return tasks;
    }
}
