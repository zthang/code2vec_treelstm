public static PrimitiveIterator.OfDouble toPrimitiveIterator(DoubleIterator iterator) {
    return new PrimitiveIterator.OfDouble() {

        public double nextDouble() {
            return iterator.next();
        }

        public boolean hasNext() {
            return iterator.hasNext();
        }
    };
}