private void dfs(int x, ArrayList<Integer>[] adj, int[] seq, int p, int ind) {
    seq[ind] = x;
    for (int t : adj[x]) {
        if (t != p) {
            dfs(t, adj, seq, x, ind + 1);
        }
    }
}