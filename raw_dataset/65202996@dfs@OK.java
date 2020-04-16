public static void dfs(int cur, ArrayList<Integer>[] adj) {
    comp[cur] = c;
    for (int nex : adj[cur]) {
        if (comp[nex] == -1) {
            dfs(nex, adj);
        }
    }
}