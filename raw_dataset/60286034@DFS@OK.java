static void DFS(int node) {
    used[node] = true;
    visited[node] = true;
    for (Edge edge : map[node]) {
        if (used[edge.u]) {
            if (visited[edge.u]) {
                color[edge.index] = 2;
                numOfColors = 2;
            }
        } else
            DFS(edge.u);
    }
    visited[node] = false;
}