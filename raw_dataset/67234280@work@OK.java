void work(int p, int s, int e, int a, int b, int k, int pid) {
    if (!ok)
        return;
    if (s > e || s > b || e < a)
        return;
    if (seg[p] <= k)
        return;
    if (s >= a && e <= b && s == e) {
        ok &= dsu.union(pid, id[p]);
        edges++;
        if (edges > maxEdges)
            ok = false;
        return;
    }
    int m = (s + e) >> 1, l = 2 * p, r = 2 * p + 1;
    work(l, s, m, a, b, k, pid);
    work(r, m + 1, e, a, b, k, pid);
}