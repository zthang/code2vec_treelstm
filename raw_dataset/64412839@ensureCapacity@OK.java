private void ensureCapacity(int minCapacity) {
    if (arr.length >= minCapacity)
        return;
    int newCapacity = minCapacity + length;
    if (newCapacity < 0)
        newCapacity = Integer.MAX_VALUE;
    arr = Arrays.copyOf(arr, newCapacity);
}