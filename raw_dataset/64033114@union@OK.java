static void union(int a, int b, int[] par, int[] rank) {
    if (rank[a] >= rank[b]) {
        par[b] = a;
        rank[a] += rank[b];
    } else {
        par[a] = b;
        rank[b] += rank[a];
    }
}