private static void union(int u, int v) {
    int a = findparent(u), b = findparent(v);
    if (a == b)
        return;
    if (rank[a] > rank[b]) {
        parent[b] = a;
        size[a] += size[b];
    } else if (rank[b] > rank[a]) {
        parent[a] = b;
        size[b] += size[a];
    } else {
        rank[a]++;
        parent[b] = a;
        size[a] += size[b];
    }
}