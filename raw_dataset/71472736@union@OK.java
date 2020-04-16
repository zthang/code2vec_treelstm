void union(int x, int y) {
    int xRoot = find(x), yRoot = find(y);
    if (xRoot == yRoot)
        return;
    differentSets--;
    if (rank[xRoot] < rank[yRoot])
        parent[xRoot] = yRoot;
    else if (rank[yRoot] < rank[xRoot])
        parent[yRoot] = xRoot;
    else {
        parent[yRoot] = xRoot;
        rank[xRoot] = rank[xRoot] + 1;
    }
}