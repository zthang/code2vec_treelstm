private static void dfs(int v, int par, int[] subtree) {
    for (int child : edges[v]) {
        if (child != par) {
            dfs(child, v, subtree);
            subtree[v] += Math.max(subtree[child], 0);
        }
    }
}