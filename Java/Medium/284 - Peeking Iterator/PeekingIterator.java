public class PeekingIterator {
    private Iterator<Integer> iterator;
    private Integer saved = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (saved != null) return saved;

        return saved = iterator.next();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (saved != null) {
            Integer copy = saved;
            saved = null;
            return copy;
        }

        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return saved != null || iterator.hasNext();
    }
}