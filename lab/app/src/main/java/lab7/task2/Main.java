package lab7.task2;

import utils.MainTask;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

public class Main implements MainTask {
    @Override
    public void main() {
        Path startingDir = Paths.get("src/main/java");
        JavaFilesVisitor filesVisitor = new JavaFilesVisitor();

        /*
         * The walkFileTree methods does a depth-first traversal of a directory, starting from startingDir.
         * When it reaches a file, the visitFile method is invoked on the currently visited file.
         */
        try {
            Files.walkFileTree(startingDir, filesVisitor);
            ArrayList<Path> javaFiles = filesVisitor.getJavaFiles();

            System.out.println("Visited files: " + javaFiles.size());

            for (Path path : javaFiles)
                System.out.println(path.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getId() {
        return 2;
    }
}
