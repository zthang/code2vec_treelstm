public boolean containsKey(int x) {
    int pos = h(x) & mask;
    while (allocated[pos] != null) {
        if (x == keys[pos])
            return true;
        pos = pos + 1 & mask;
    }
    return false;
}