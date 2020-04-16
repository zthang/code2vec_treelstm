public static <T> Set<T> asModifiableSet(Collection<T> uniqueElements) {
    return new AbstractSet<T>() {

        public int size() {
            return uniqueElements.size();
        }

        public boolean isEmpty() {
            return uniqueElements.isEmpty();
        }

        public boolean contains(Object o) {
            return uniqueElements.contains(o);
        }

        public Iterator<T> iterator() {
            return uniqueElements.iterator();
        }

        public Object[] toArray() {
            return uniqueElements.toArray();
        }

        public <T1> T1[] toArray(T1[] a) {
            return uniqueElements.toArray(a);
        }

        public boolean add(T t) {
            return uniqueElements.add(t);
        }

        public boolean remove(Object o) {
            return uniqueElements.remove(o);
        }

        public boolean containsAll(Collection<?> c) {
            return uniqueElements.containsAll(c);
        }

        public boolean addAll(Collection<? extends T> c) {
            return uniqueElements.addAll(c);
        }

        public boolean retainAll(Collection<?> c) {
            return uniqueElements.retainAll(c);
        }

        public boolean removeAll(Collection<?> c) {
            return uniqueElements.removeAll(c);
        }

        public void clear() {
            uniqueElements.clear();
        }
    };
}