public int query(int node, int lo, int hi, int fr, int to) {
    if (fr == lo && to == hi)
        return tree[node];
    int m = (lo + hi) / 2;
    if (to <= m)
        return query(node * 2, lo, m, fr, to);
    else if (fr > m)
        return query(node * 2 + 1, m + 1, hi, fr, to);
    int lid = query(node * 2, lo, m, fr, m);
    int rid = query(node * 2 + 1, m + 1, hi, m + 1, to);
    return a[lid] >= a[rid] ? lid : rid;
}