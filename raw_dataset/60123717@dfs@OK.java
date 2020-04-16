static void dfs(int node, int ret, int c) {
    inpath.add(node);
    for (int i : adj[node]) {
        if (i < ret || inpath.contains(i)) {
            continue;
        } else {
            if (i == ret) {
                ans[adjmat[node][i]] = c + 1;
            } else {
                dfs(i, ret, c);
            }
        }
    }
}