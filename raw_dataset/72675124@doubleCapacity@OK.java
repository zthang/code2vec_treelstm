private void doubleCapacity() {
    int newSize = Math.max(next.length + 10, next.length * 2);
    next = Arrays.copyOf(next, newSize);
    keys = Arrays.copyOf(keys, newSize);
    values = Arrays.copyOf(values, newSize);
    removed = Arrays.copyOf(removed, newSize);
}