public static void merge(int x, int y) {
    int fx = find(x);
    int fy = find(y);
    if (rank[fx] < rank[fy]) {
        sz[fy] += sz[fx];
        par[fx] = fy;
    } else if (rank[fy] < rank[fx]) {
        sz[fx] += sz[fy];
        par[fy] = fx;
    } else {
        par[fy] = fx;
        sz[fx] += sz[fy];
        rank[fx]++;
    }
}