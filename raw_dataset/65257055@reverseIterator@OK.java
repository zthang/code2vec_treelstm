public static <T> ListIterator<T> reverseIterator(ListIterator<T> it) {
    return new ListIterator<T>() {

        public boolean hasNext() {
            return it.hasPrevious();
        }

        public T next() {
            return it.previous();
        }

        public boolean hasPrevious() {
            return it.hasNext();
        }

        public T previous() {
            return it.next();
        }

        public int nextIndex() {
            return it.previousIndex();
        }

        public int previousIndex() {
            return it.nextIndex();
        }

        public void remove() {
            it.remove();
        }

        public void set(T t) {
            it.set(t);
        }

        public void add(T t) {
            it.add(t);
        }
    };
}