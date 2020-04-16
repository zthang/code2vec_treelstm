public void unionSet(int i, int j, int cost) {
    if (isSameSet(i, j))
        return;
    numSets--;
    int x = findSet(i), y = findSet(j);
    int a = setSize[x], b = setSize[y];
    if (rank[x] > rank[y]) {
        p[y] = x;
        setSize[x] += setSize[y];
    } else {
        p[x] = y;
        setSize[y] += setSize[x];
        if (rank[x] == rank[y])
            rank[y]++;
    }
    while (pointer < queries.length && queries[pointer].q < cost) pointer++;
    if (pointer < queries.length)
        queries[pointer].ans += 1l * a * b;
}