long dfs1(int p, int u, int[] w, Set<Integer>[] set, Set<Integer> tree, List<Integer>[] g) {
    long max = 0;
    tree.add(u);
    for (int v : g[u]) {
        if ((v == p) || (set[v].isEmpty() == false)) {
            continue;
        }
        max = max(max, dfs1(u, v, w, set, tree, g));
    }
    return max + w[u];
}