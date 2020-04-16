public void dfs(int node, int parent) {
    if (parent != -1)
        depth[node] = depth[parent] + 1;
    this.parent[node][0] = parent;
    for (int i : G[node]) {
        if (i == parent)
            continue;
        dfs(i, node);
    }
}