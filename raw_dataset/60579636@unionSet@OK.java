public boolean unionSet(int i, int j) {
    if (isSameSet(i, j))
        return false;
    numSets--;
    int x = findSet(i), y = findSet(j);
    if (rank[x] > rank[y]) {
        p[y] = x;
        setSize[x] += setSize[y];
    } else {
        p[x] = y;
        setSize[y] += setSize[x];
        if (rank[x] == rank[y])
            rank[y]++;
    }
    return true;
}