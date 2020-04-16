static int minIndex(long[] t) {
    int res = 1;
    while (res < t.length / 2) res = res * 2 + (t[res * 2] > t[1] ? 1 : 0);
    return res - t.length / 2;
}