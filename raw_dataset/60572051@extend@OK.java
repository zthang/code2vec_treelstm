static int extend(int cur, int val) {
    long key = (cur & 0xffffffffL) | ((long) val << 32);
    long res = fwd.get(key, -1);
    if (res >= 0) {
        return (int) res;
    }
    int r = cnt++;
    vals[r] = val;
    prevs[0][r] = cur;
    for (int i = 1; i < 20; i++) {
        prevs[i][r] = cur = cur < 0 ? -1 : prevs[i - 1][cur];
    }
    fwd.set(key, r);
    return r;
}