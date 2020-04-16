static void Union(int[] parent, int[] rank, int[] sum, int x, int y) {
    int xroot = find(parent, rank, x);
    int yroot = find(parent, rank, y);
    if (rank[xroot] < rank[yroot]) {
        parent[xroot] = yroot;
        sum[yroot] += sum[xroot];
    } else if (rank[yroot] < rank[xroot]) {
        parent[yroot] = xroot;
        sum[xroot] += sum[yroot];
    } else {
        parent[xroot] = yroot;
        sum[yroot] += sum[xroot];
        rank[yroot]++;
    }
}