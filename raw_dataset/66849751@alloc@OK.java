public void alloc() {
    alloc++;
    if (alloc >= next.length) {
        doubleCapacity();
    }
    next[alloc] = 0;
}