private static long[] pathQuery(int[][] edges, int n, int[][] maxWeights) {
    long sum = 0;
    long[] res = new long[maxWeights.length];
    UnionFind uf = new UnionFind(n);
    int j = 0;
    for (int i = 0; i < maxWeights.length; i++) {
        while (j < edges.length && edges[j][2] <= maxWeights[i][0]) {
            sum += uf.union(edges[j][0] - 1, edges[j][1] - 1);
            j++;
        }
        res[maxWeights[i][1]] = sum;
    }
    return res;
}