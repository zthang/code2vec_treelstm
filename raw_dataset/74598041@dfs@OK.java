static void dfs(int u, int prev) {
    for (int v : adj[u]) {
        if (v == prev) {
            continue;
        }
        parent[v] = u;
        firstAppear[v] = count;
        dist[v] = dist[u] + 1;
        eulerTour[count] = v;
        count++;
        dfs(v, u);
        eulerTour[count] = u;
        count++;
    }
}