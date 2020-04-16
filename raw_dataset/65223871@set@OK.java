static void set(long[] t, int i, long value) {
    i += t.length / 2;
    if (t[i] < value && value != Long.MAX_VALUE)
        return;
    t[i] = value;
    for (; i > 1; i >>= 1) t[i >> 1] = Math.min(t[i], t[i ^ 1]);
}