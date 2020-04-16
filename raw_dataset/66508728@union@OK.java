void union(int x, int y) {
    x = findSet(x);
    y = findSet(y);
    if (x == y)
        return;
    if (rank[x] > rank[y]) {
        p[y] = x;
    } else {
        p[x] = y;
        if (rank[x] == rank[y]) {
            rank[y]++;
        }
    }
    numSets--;
}