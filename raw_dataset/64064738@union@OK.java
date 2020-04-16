private static void union(int[] parent, long[] rank, int a, int b) {
    if (rank[a] < rank[b])
        parent[b] = a;
    else
        parent[a] = b;
}