package lab9.task3;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    private String spacerSymbols = new String(new char[40]).replace("\0", "-");

    private void printOutputSpacerFor(String test) {
        System.out.println(spacerSymbols + test + spacerSymbols);
    }

    private void testDraw(Client client) {
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");

        client.showDiagram();
    }

    private void testTextAndColor(Client client) {
        testDraw(client);
        client.executeAction("change color", "0", "RED");
        client.executeAction("change color", "1", "BLUE");
        client.executeAction("draw rectangle");
        client.executeAction("change text", "0", "MyClass1");
        client.executeAction("change text", "5", "MyClass2");
        client.showDiagram();
    }

    private void testConnect(Client client) {
        testDraw(client);
        client.executeAction("connect", "0", "1");
        client.executeAction("connect", "3", "2");
        client.executeAction("connect", "1", "4");
        client.executeAction("draw rectangle");
        client.showDiagram();
    }

    private void testResize(Client client) {
        testDraw(client);
        client.executeAction("resize", "0", "10");
        client.executeAction("resize", "2", "50");
        client.executeAction("resize", "4", "25");
        client.showDiagram();
    }

    private void testAllCommands(Client client) {
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("resize", "0", "10");
        client.executeAction("change color", "2", "PINK");
        client.executeAction("connect", "2", "1");
        client.executeAction("draw rectangle");
        client.executeAction("change text", "1", "Class1");
        client.executeAction("change text", "3", "Class2");

        client.showDiagram();
    }

    private void testSimpleUndoRedo(Client client) {
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("change color", "0", "ORANGE");
        client.showDiagram();

        client.executeAction("draw rectangle");
        client.showDiagram();

        client.undo();
        client.showDiagram();

        client.redo();
        client.showDiagram();
    }

    private void testComplexUndoRedo(Client client) {
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("resize", "0", "10");
        client.executeAction("change color", "2", "PINK");
        client.executeAction("connect", "2", "1");
        client.executeAction("draw rectangle");
        client.executeAction("change text", "1", "Class1");
        client.executeAction("change color", "3", "RED");
        client.showDiagram();
        client.undo();
        client.undo();
        client.showDiagram();

        client.undo();
        client.undo();
        client.showDiagram();

        client.redo();
        client.redo();
        client.executeAction("resize", "2", "50");
        client.showDiagram();
    }


    @Override
    public void main() {
        Client client = new Client();

        printOutputSpacerFor("testDraw");
        testDraw(client);

        printOutputSpacerFor("testTextAndColor");
        testTextAndColor(client);

        printOutputSpacerFor("testResize");
        testResize(client);

        printOutputSpacerFor("testConnect");
        testConnect(client);

        printOutputSpacerFor("testAllCommands");
        testAllCommands(client);

        printOutputSpacerFor("testSimpleUndoRedo");
        testSimpleUndoRedo(client);

        printOutputSpacerFor("testComplexUndoRedo");
        testComplexUndoRedo(client);
    }

    @Override
    public int getId() {
        return 3;
    }
}
