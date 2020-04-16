public void union(int p, int q) {
    int i = find(p);
    int j = find(q);
    if (i == j) {
        return;
    }
    if (this.sz[i] < this.sz[j]) {
        this.id[i] = j;
        this.sz[j] += this.sz[i];
        this.range[j][0] = Math.min(this.range[i][0], this.range[j][0]);
        this.range[j][1] = Math.max(this.range[i][1], this.range[j][1]);
    } else {
        this.id[j] = i;
        this.sz[i] += this.sz[j];
        this.range[i][0] = Math.min(this.range[i][0], this.range[j][0]);
        this.range[i][1] = Math.max(this.range[i][1], this.range[j][1]);
    }
    this.count--;
}