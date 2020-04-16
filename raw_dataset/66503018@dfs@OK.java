private static void dfs(Set<Integer>[] g, int[] used, int i) {
    used[i] = 1;
    for (int node : g[i]) {
        if (used[node] == 0)
            dfs(g, used, node);
    }
}