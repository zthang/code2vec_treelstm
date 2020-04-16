public static void dfs(int node) {
    used[node] = 1;
    ArrayList<Edge> nn = graph.get_n(node);
    for (Edge e : nn) {
        if (used[e.to] == 0) {
            dfs(e.to);
            color[e.ind] = 1;
        } else if (used[e.to] == 2) {
            color[e.ind] = 1;
        } else {
            color[e.ind] = 2;
            ans = 2;
        }
    }
    used[node] = 2;
}