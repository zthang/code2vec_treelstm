public void union(int p, int q) {
    int rootq = find(q);
    int rootp = find(p);
    if (rootp == rootq)
        return;
    ids[rootq] = rootp;
}