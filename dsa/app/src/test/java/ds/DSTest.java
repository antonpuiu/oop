package ds;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public abstract class DSTest<T> {
    protected T ds;

    @BeforeEach
    public void setup(TestInfo testInfo) {
        String methodName = testInfo.getTestMethod().orElseThrow().getName();

        ds = getDS();

        System.out.println("Testing " + methodName);
    }

    @AfterEach
    public void clean() {
        ds = null;

        System.out.println("done");
    }

    public abstract T getDS();
}
