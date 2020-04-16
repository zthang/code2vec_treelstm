long dfs2(int p, int u, int[] w, Set<Integer>[] set, List<Integer>[] g, long loopSum) {
    if (set[u].isEmpty()) {
        long max = 0;
        for (int v : g[u]) {
            if (v == p) {
                continue;
            }
            max = max(max, dfs2(u, v, w, set, g, loopSum));
        }
        return max + w[u];
    } else {
        return loopSum;
    }
}