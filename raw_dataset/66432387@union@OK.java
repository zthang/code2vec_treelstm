private static void union(int[] parent, int[] rank, int i, int j) {
    int a = findParent(parent, i), b = findParent(parent, j);
    if (a == b)
        return;
    if (rank[a] > rank[b])
        parent[b] = a;
    else if (rank[b] > rank[a])
        parent[a] = b;
    else {
        rank[a]++;
        parent[b] = a;
    }
}