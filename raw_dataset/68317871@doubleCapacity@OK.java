private void doubleCapacity() {
    int newSize = Math.max(next.length + 10, next.length * 2);
    next = Arrays.copyOf(next, newSize);
    values = Arrays.copyOf(values, newSize);
}