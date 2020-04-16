static void dfs(ArrayList<Integer>[] adj, int i, int[] subcnt) {
    subcnt[i] = 1;
    for (int j : adj[i]) {
        dfs(adj, j, subcnt);
        subcnt[i] += subcnt[j];
    }
}