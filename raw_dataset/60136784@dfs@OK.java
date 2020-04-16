static void dfs(int v) {
    col[v] = 1;
    for (Edge edge : graph[v]) {
        if (edge.c != 0)
            continue;
        else if (col[edge.v] == 1) {
            edge.c = 2;
        } else {
            edge.c = 1;
            dfs(edge.v);
        }
    }
    col[v] = 2;
}