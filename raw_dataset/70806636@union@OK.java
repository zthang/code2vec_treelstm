long union(int x, int y) {
    if (sz[x] > sz[y]) {
        int tmp = x;
        x = y;
        y = tmp;
    }
    sz[y] += sz[x];
    cost[y] += cost[x];
    F[x] = y;
    return cost[y];
}