public void addLast(int qId, int x) {
    alloc();
    values[alloc] = x;
    next[alloc] = heads[qId];
    heads[qId] = alloc;
}