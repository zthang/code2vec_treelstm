boolean dfs3(int p, int u, int[] w, Set<Integer>[] set, List<Integer>[] g, Set<Integer> path) {
    if (set[u].isEmpty()) {
        boolean onpath = false;
        for (int v : g[u]) {
            if (v == p) {
                continue;
            }
            onpath |= dfs3(u, v, w, set, g, path);
        }
        if (onpath) {
            path.add(u);
        }
        return onpath;
    } else {
        return true;
    }
}