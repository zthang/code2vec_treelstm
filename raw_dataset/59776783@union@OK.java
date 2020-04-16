public long union(int p, int q) {
    int i = find(p);
    int j = find(q);
    if (i == j) {
        return 0;
    }
    long res = (sz[i] + sz[j]) * (sz[i] + sz[j] - 1) / 2 - sz[i] * (sz[i] - 1) / 2 - sz[j] * (sz[j] - 1) / 2;
    if (this.sz[i] < this.sz[j]) {
        this.id[i] = j;
        this.sz[j] += this.sz[i];
    } else {
        this.id[j] = i;
        this.sz[i] += this.sz[j];
    }
    return res;
}