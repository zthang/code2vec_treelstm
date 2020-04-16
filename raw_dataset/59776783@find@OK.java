public int find(int p) {
    if (p != this.id[p]) {
        this.id[p] = find(this.id[p]);
    }
    return this.id[p];
}