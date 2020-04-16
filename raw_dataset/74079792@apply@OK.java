public int apply(int x, int p) {
    int i = idx[x];
    int dist = DigitUtils.mod((i - l[i]) + p, r[i] - l[i] + 1);
    return g[dist + l[i]];
}