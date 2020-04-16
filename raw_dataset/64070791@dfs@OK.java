private boolean dfs(int x, int[] res, HashSet<Integer>[] adj, boolean[] vis, HashSet<Integer>[] che) {
    for (int i = 0; i < 3; i++) {
        for (int h : che[i]) {
            for (int k : adj[h]) {
                if (che[i].contains(k)) {
                    return false;
                }
            }
        }
    }
    return true;
}