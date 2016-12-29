package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator implements Iterator<String> {
    // Iterator役
    // Iteratorは、hasNextメソッドとnextメソッドを実装する
    // JavaではビルドインのIteratorインターフェースを利用することで、
    // Iteratorを実装しやすくなっている

    private String list[];
    private int size = 0;
    private int curIndex = 0;

    public ListIterator(String[] list, int size) {
        this.list = list;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return curIndex < size;
    }

    @Override
    public String next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        return list[curIndex++];
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
