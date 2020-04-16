public void unite(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y)
        return;
    else if (rank[x] > rank[y]) {
        par[x] += par[y];
        par[y] = x;
    } else {
        par[y] += par[x];
        par[x] = y;
        if (rank[x] == rank[y])
            rank[y]++;
    }
    g--;
}