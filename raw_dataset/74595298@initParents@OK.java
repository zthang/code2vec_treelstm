private void initParents(int root, int d) {
    dists[root] = d;
    inDists[root] = T++;
    for (int x : edges.get(root)) {
        if (parents[x] == 0) {
            parents[x] = root;
            initParents(x, d + 1);
        }
    }
    outDists[root] = T++;
}