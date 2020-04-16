public void unionSet1(int x, int y) {
    if (rank[x] > rank[y]) {
        p[y] = x;
        setSize[x] += setSize[y];
    } else {
        p[x] = y;
        setSize[y] += setSize[x];
        if (rank[x] == rank[y])
            rank[y]++;
    }
}