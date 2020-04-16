boolean merge(int u, int v) {
    int pu = get(u), pv = get(v);
    if (pu == pv)
        return false;
    ed++;
    if (r[pu] == r[pv])
        r[pu]++;
    if (r[pu] < r[pv]) {
        p[pu] = pv;
    } else {
        p[pv] = pu;
    }
    return ed < n;
}