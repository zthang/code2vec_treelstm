public void unionSet(int i, int j) {
    if (isSameSet(i, j))
        return;
    numSets--;
    int x = findSet(i), y = findSet(j);
    if (rank[x] > rank[y]) {
        for (int zz : ele[y]) ele[x].add(zz);
        p[y] = x;
        setSize[x] += setSize[y];
    } else {
        for (int zz : ele[x]) ele[y].add(zz);
        p[x] = y;
        setSize[y] += setSize[x];
        if (rank[x] == rank[y])
            rank[y]++;
    }
}