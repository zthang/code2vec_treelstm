public int getCountInOneComponent(int p) {
    int root = find(p);
    return this.sz[root];
}