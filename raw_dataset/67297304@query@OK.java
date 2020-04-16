int query(int node, int tl, int tr, int l, int r, int x) {
    if (tr < l || r < tl || max[node] <= x)
        return -1;
    if (tl == tr)
        return tl;
    int mid = tl + tr >> 1, left = node << 1, right = left | 1;
    int ans = query(left, tl, mid, l, r, x);
    return ans == -1 ? query(right, mid + 1, tr, l, r, x) : ans;
}