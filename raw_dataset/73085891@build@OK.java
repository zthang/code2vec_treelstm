public void build(int node, int start, int end) {
    if (start == end) {
        seg[node] = 0;
        return;
    }
    int mid = (start + end) / 2;
    build(2 * node + 1, start, mid);
    build(2 * node + 2, mid + 1, end);
    seg[node] = seg[2 * node + 1] + seg[2 * node + 2];
}