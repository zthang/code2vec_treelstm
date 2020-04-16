boolean merge(int u, int v) {
    int pu = find(u);
    int pv = find(v);
    if (pu == pv) {
        return false;
    }
    p[pu] = pv;
    return true;
}