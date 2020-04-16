public void union(int u, int v) {
    int x = findParent(u);
    int y = findParent(v);
    if (x == y)
        return;
    if (rank[x] >= rank[y]) {
        parent[y] = x;
        setSize[x] += setSize[y];
        if (rank[x] == rank[y])
            rank[x]++;
    } else {
        parent[x] = y;
        setSize[y] += setSize[x];
    }
    sets--;
}