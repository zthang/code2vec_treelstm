public Object get(int x) {
    int pos = h(x) & mask;
    while (allocated[pos] != null) {
        if (x == keys[pos])
            return allocated[pos];
        pos = pos + 1 & mask;
    }
    return null;
}