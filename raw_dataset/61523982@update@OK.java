public void update(int node, int start, int end, int fi, long val) {
    if (start == end) {
        seg[node] += val;
        seg[node] %= mod;
        return;
    }
    int mid = (start + end) / 2;
    if (fi >= start && fi <= mid) {
        update(2 * node + 1, start, mid, fi, val);
    } else
        update(2 * node + 2, mid + 1, end, fi, val);
    seg[node] = (seg[2 * node + 1] + seg[2 * node + 2]) % mod;
}