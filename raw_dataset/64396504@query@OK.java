int query(int node, int tl, int tr, int l, int r, int v) {
    if (tr < l || r < tl || (max[node] == v && min[node] == v))
        return -1;
    if (tl == tr)
        return tl;
    int mid = tl + tr >> 1, left = node << 1, right = left | 1;
    int x = query(left, tl, mid, l, r, v);
    if (x != -1)
        return x;
    return query(right, mid + 1, tr, l, r, v);
}