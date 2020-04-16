public Iterator<Long> iterator() {
    return new PolyfillIterator<Long>() {

        long c = getLeft();

        public boolean hasNext() {
            return c < getRight();
        }

        public Long next() {
            return c++;
        }
    };
}