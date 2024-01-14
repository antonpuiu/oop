package lab10.task2;

import java.util.HashSet;
import java.util.List;

public interface Tree<T extends Comparable<T>> {

    void addValue(T value);

    void addAll(List<T> values);

    HashSet<T> getValues(T inf, T sup);

    int size();

    boolean isEmpty();
}
