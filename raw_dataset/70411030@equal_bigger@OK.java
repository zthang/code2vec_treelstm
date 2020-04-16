int equal_bigger(long[] t, long v) {
    int s = 0, p = 0;
    for (int i = Integer.numberOfTrailingZeros(Integer.highestOneBit(t.length)); i >= 0; --i) {
        if (p + (1 << i) < t.length && s + t[p + (1 << i)] < v) {
            v -= t[p + (1 << i)];
            p |= 1 << i;
        }
    }
    return p + 1;
}