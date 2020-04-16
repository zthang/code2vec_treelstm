public void unite(int x, int y, int t) {
    now = t;
    x = find(t, x);
    y = find(t, y);
    if (x == y)
        return;
    if (rank[x] < rank[y]) {
        root[x] = y;
        size[y] += size[x];
        time[x] = t;
    } else {
        root[y] = x;
        size[x] += size[y];
        if (rank[x] == rank[y]) {
            rank[x]++;
        }
        time[y] = t;
    }
}