static int query(int x, int[] ft) {
    int ans = 0;
    for (; x > 0; x ^= x & -x) ans += ft[x];
    return ans;
}