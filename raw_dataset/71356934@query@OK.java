long query(int node, int left, int right, int start, int end) {
    if (left > end || right < start) {
        return NEG_INF;
    }
    if (left >= start && right <= end) {
        return tree[node];
    }
    int mid = (left + right) / 2;
    long val1 = query(2 * node, left, mid, start, end);
    long val2 = query(2 * node + 1, mid + 1, right, start, end);
    return max(val1, val2);
}