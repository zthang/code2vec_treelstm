public static void bfs(int u) {
    visited[u] = explore;
    for (Pair p : adjList[u]) {
        int v = p.a;
        int idx = p.b;
        if (visited[v] == vis) {
            ans[idx] = 1;
            continue;
        } else if (visited[v] == explore) {
            ans[idx] = 2;
        } else {
            ans[idx] = 1;
            bfs(v);
        }
    }
    visited[u] = vis;
}