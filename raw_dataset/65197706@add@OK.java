private void add(int p, int q) {
    int rp = find(p);
    int rq = find(q);
    if (rp == rq)
        return;
    if (sz[rp] < sz[rq]) {
        sz[rq] += sz[rp];
        par[rp] = rq;
        gmax[rq] = Math.max(gmax[rq], gmax[rp]);
    } else {
        sz[rp] += sz[rq];
        par[rq] = rp;
        gmax[rp] = Math.max(gmax[rq], gmax[rp]);
    }
}