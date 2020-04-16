static void union(int u, int v, int[] parent, int[] rank) {
    if (rank[u] > rank[v])
        parent[v] = u;
    else if (rank[u] < rank[v])
        parent[u] = v;
    else {
        rank[u]++;
        parent[v] = u;
    }
}