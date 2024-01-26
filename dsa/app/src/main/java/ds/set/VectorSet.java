package ds.set;

import java.util.Iterator;

import ds.list.List;
import ds.list.custom.ArrayList;

public class VectorSet<T> extends Set<T> {
    @Override
    protected List<T> getDS() {
        return new ArrayList<T>();
    }

    @Override
    public Iterator<T> iterator() {
        return ((ArrayList<T>)values).iterator();
    }
}
