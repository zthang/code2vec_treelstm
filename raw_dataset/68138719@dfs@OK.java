static void dfs(int node, int par) {
    if (!vis.contains(node)) {
        vis.add(node);
        for (int adj : adjList[node]) {
            if (adj != par) {
                dfs(adj, node);
            }
        }
    }
}