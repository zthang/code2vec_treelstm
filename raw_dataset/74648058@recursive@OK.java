public static int recursive(int node) {
    int c = 1;
    for (int child : graph[node]) {
        if (!vis[child]) {
            vis[child] = true;
            parent[child] = node;
            depth[child] = depth[node] + 1;
            c += recursive(child);
        }
    }
    cnt[node] = c;
    return cnt[node];
}