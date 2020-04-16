public Object put(int x, Object v) {
    int pos = h(x) & mask;
    while (allocated[pos] != null) {
        if (x == keys[pos]) {
            Object oldval = allocated[pos];
            allocated[pos] = v;
            return oldval;
        }
        pos = pos + 1 & mask;
    }
    if (size == rscale) {
        resizeAndPut(x, v);
    } else {
        keys[pos] = x;
        allocated[pos] = v;
    }
    size++;
    return null;
}