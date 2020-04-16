static long solve(int k, int s, ArrayList<Edge>[] graph, boolean[] red) {
    if (k == 0) {
        if (s == 0)
            return 0;
        return oo;
    }
    if (ver[k][s] == iter)
        return dp[k][s];
    long res = oo;
    for (Edge t : graph[s]) {
        if (red[s] != red[t.to]) {
            res = Math.min(res, t.weight + solve(k - 1, t.to, graph, red));
        }
    }
    ver[k][s] = iter;
    return dp[k][s] = res;
}