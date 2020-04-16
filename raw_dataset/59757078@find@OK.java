static int find(int[] parent, int[] rank, int i) {
    if (parent[i] != i)
        parent[i] = find(parent, rank, parent[i]);
    return parent[i];
}