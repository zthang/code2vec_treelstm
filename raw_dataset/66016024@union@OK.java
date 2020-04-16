void union(int p, int q) {
    int rp = find(p);
    int rq = find(q);
    if (rp != rq) {
        if (sz[rq] <= sz[rp]) {
            root[rq] = rp;
            sz[rp] += sz[rq];
        // count--;
        } else {
            root[rp] = rq;
            sz[rq] += sz[rp];
        // count--;
        }
        count--;
    }
}