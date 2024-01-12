package lab8.task5;

import java.util.LinkedHashSet;

public class LinkedEvenSet extends LinkedHashSet<Integer> {
    @Override
    public boolean add(Integer e) {
        if (e % 2 == 1)
            return false;

        return super.add(e);
    }
}
