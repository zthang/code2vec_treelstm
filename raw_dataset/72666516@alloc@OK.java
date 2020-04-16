public void alloc() {
    alloc++;
    if (alloc >= next.length) {
        doubleCapacity();
    }
    next[alloc] = 0;
    removed[alloc] = false;
    values[alloc] = null;
    size++;
}