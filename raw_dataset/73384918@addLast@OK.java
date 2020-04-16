public void addLast(int x) {
    ensureMore();
    data[epos] = x;
    epos = next(epos);
}