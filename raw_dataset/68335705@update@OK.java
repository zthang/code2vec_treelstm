void update(int n, int s, int e, int idx, int diff) {
    if (idx < s || e < idx) {
        return;
    }
    t[n] += diff;
    if (s != e) {
        update(2 * n, s, (s + e) / 2, idx, diff);
        update(2 * n + 1, (s + e) / 2 + 1, e, idx, diff);
    }
}