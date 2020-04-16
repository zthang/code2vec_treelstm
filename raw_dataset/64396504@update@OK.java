void update(int node, int tl, int tr, int idx, int v) {
    if (tl == tr) {
        min[node] = max[node] = v;
    } else {
        int mid = tl + tr >> 1, left = node << 1, right = left | 1;
        if (idx <= mid)
            update(left, tl, mid, idx, v);
        else
            update(right, mid + 1, tr, idx, v);
        min[node] = Math.min(min[left], min[right]);
        max[node] = Math.max(max[left], max[right]);
    }
}