private void pushDown(int node, int lo, int hi) {
    if (lazy[node] == 0)
        return;
    int lz = lazy[node];
    lazy[node] = 0;
    treeMin[node] += lz;
    treeMax[node] += lz;
    if (lo == hi)
        return;
    int mid = (lo + hi) / 2;
    lazy[node * 2] += lz;
    lazy[node * 2 + 1] += lz;
}