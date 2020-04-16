private String solve(int n, int m, int[] u, int[] v, int k, int[] p) {
    int[][] bg = buildGraph(n, m, v, u);
    int[] dist = buildDist(p[k - 1], n, bg);
    int[][] dg = buildGraph(n, m, u, v);
    int min = 0;
    int max = 0;
    for (int i = 0; i + 1 < k; i++) {
        int from = p[i];
        int to = p[i + 1];
        int cnt = 0;
        for (int alt : dg[from]) {
            if (dist[alt] == dist[from] - 1) {
                cnt++;
            }
        }
        if (dist[to] == dist[from] - 1) {
            if (cnt > 1) {
                max++;
            }
        } else {
            min++;
            max++;
        }
    }
    return min + " " + max;
}