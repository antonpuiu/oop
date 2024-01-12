package lab8.task5;

import java.util.TreeSet;

public class TreeEvenSet extends TreeSet<Integer> {
    @Override
    public boolean add(Integer e) {
        if (e % 2 == 1)
            return false;

        return super.add(e);
    }
}
