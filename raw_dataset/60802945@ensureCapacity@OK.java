private void ensureCapacity(int capacity) {
    if (values.length < capacity) {
        capacity = Math.max(capacity * 2, values.length);
        rebuild(capacity);
    }
}