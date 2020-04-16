public void union(int p, int q) {
    int pp = find(p);
    int qp = find(q);
    if (pp == qp) {
        return;
    }
    count -= (sz[pp] * (sz[pp] - 1)) / 2;
    count -= (sz[qp] * (sz[qp] - 1)) / 2;
    count += (sz[pp] + sz[qp]) * (sz[pp] + sz[qp] - 1) / 2;
    if (sz[pp] > sz[qp]) {
        iDs[qp] = pp;
        sz[pp] += sz[qp];
    } else {
        iDs[pp] = qp;
        sz[qp] += sz[pp];
    }
}