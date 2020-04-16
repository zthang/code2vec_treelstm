private boolean add(int p, int q) {
    int rp = find(p);
    int rq = find(q);
    if (rq == rp)
        return false;
    if (sz[rp] <= sz[rq]) {
        sz[rq] += sz[rp];
        par[rp] = rq;
    } else {
        sz[rp] += sz[rq];
        par[rq] = rp;
    }
    nGroup--;
    return true;
}