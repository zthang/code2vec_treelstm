void unionSet(int i, int j) {
    if (!isSameSet(i, j)) {
        int x = findSet(i);
        int y = findSet(j);
        if (rank[x] > rank[y]) {
            p[y] = x;
        } else {
            p[x] = y;
            if (rank[x] == rank[y]) {
                rank[y]++;
            }
        }
    }
}