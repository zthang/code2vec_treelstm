static void dfs(ArrayList<Integer>[] adj, int here, int from, ArrayList<Integer> res) {
    res.add(here);
    for (int there : adj[here]) {
        if (there != from)
            dfs(adj, there, here, res);
    }
}