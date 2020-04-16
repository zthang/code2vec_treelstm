void union(int p, int q) {
    int pr = findRoot(p);
    int qr = findRoot(q);
    if (pr != qr) {
        if (sz[qr] <= sz[pr]) {
            root[qr] = pr;
            sz[pr] += sz[qr];
        } else {
            root[pr] = qr;
            sz[qr] += sz[pr];
        }
        components--;
    }
}