public void unify(int p, int q) {
    int root1 = find(p);
    int root2 = find(q);
    if (root1 == root2)
        return;
    if (sz[root1] < sz[root2]) {
        sz[root2] += sz[root1];
        id[root1] = root2;
    } else {
        sz[root1] += sz[root2];
        id[root2] = root1;
    }
    numComponents--;
}