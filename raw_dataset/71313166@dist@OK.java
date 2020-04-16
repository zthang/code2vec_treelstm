static int dist(int a, int b, int dist) {
    if (a == b)
        return 0;
    if (depth[a] > depth[b]) {
        int num = Integer.numberOfTrailingZeros(depth[a] - depth[b]);
        return (1 << num) + dist(par[num][a], b, dist);
    }
    if (depth[b] > depth[a]) {
        int num = Integer.numberOfTrailingZeros(depth[b] - depth[a]);
        return (1 << num) + dist(a, par[num][b], dist);
    }
    if (dist == -1)
        return 2;
    if (par[dist][a] == par[dist][b])
        return dist(a, b, dist - 1);
    return 2 * (1 << dist) + dist(par[dist][a], par[dist][b], dist - 1);
}