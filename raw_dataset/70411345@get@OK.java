long get(long[] t, int i) {
    long s = 0;
    for (; i > 0; i -= (i & -i)) {
        s += t[i];
    }
    return s;
}