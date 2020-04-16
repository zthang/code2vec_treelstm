public static int dfs(Graph g, int node, int par, boolean[] vis) {
    vis[node] = true;
    int answer = 0;
    for (Graph.Edge edge : g.getEdges(node)) {
        int next = edge.v;
        if (next != par && !vis[next]) {
            answer += 1;
            answer += dfs(g, next, node, vis);
        }
    }
    return answer;
}