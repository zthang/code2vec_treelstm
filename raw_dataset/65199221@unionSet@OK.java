public void unionSet(int i, int j) {
    if (isSameSet(i, j))
        return;
    numSets--;
    int x = findSet(i), y = findSet(j);
    int m = Math.max(max[x], max[y]);
    if (rank[x] > rank[y]) {
        p[y] = x;
        setSize[x] += setSize[y];
        max[x] = m;
    } else {
        p[x] = y;
        setSize[y] += setSize[x];
        if (rank[x] == rank[y])
            rank[y]++;
        max[y] = m;
    }
}