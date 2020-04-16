private int union(int i, int j) {
    int ri = root(i);
    int rj = root(j);
    if (ri == rj)
        return ri;
    if (dep[ri] >= dep[rj]) {
        data[rj] = ri;
        dep[ri] = Math.max(dep[ri], dep[rj] + 1);
        ct[ri] += ct[rj];
        return ri;
    } else {
        data[ri] = rj;
        dep[rj] = Math.max(dep[rj], dep[ri] + 1);
        ct[rj] += ct[ri];
        return rj;
    }
}