void build(int node, int tl, int tr) {
    if (tl == tr)
        max[node] = a[tl];
    else {
        int mid = tl + tr >> 1, left = node << 1, right = left | 1;
        build(left, tl, mid);
        build(right, mid + 1, tr);
        max[node] = Math.max(max[left], max[right]);
    }
}