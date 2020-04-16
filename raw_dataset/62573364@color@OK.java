long color(int c, int ind, long[] c1, long[] c2, long[] c3) {
    if (c == 1) {
        return c1[ind];
    }
    if (c == 2) {
        return c2[ind];
    }
    return c3[ind];
}