void dfs(int node, int counter, TreeSet<Integer> aset, TreeSet<Integer> dset) {
    component[node] = counter;
    aset.add(node);
    dset.add(node);
    for (int x : adj[node]) {
        if (!vis[x]) {
            vis[x] = true;
            dfs(x, counter, aset, dset);
        }
    }
}