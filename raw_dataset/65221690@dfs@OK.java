private static int dfs(int node, List<List<Integer>> graph, boolean[] vis) {
    vis[node] = true;
    int ret = node;
    for (int i = 0; i < graph.get(node).size(); i++) {
        int adjNode = graph.get(node).get(i);
        if (!vis[adjNode]) {
            ret = Math.max(ret, dfs(adjNode, graph, vis));
        }
    }
    return ret;
}