private static int BFS(int u) {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    int ans = lim;
    queue.add(u);
    dist[u] = 0;
    parent[u] = u;
    vis.add(u);
    outer: while (!queue.isEmpty()) {
        int v = queue.poll();
        int d = dist[v];
        for (int child : edge[v]) {
            if (dist[child] == -1) {
                parent[child] = v;
                dist[child] = d + 1;
                queue.add(child);
                vis.add(child);
            } else if (parent[v] != child) {
                ans = d + dist[child] + 1;
                break outer;
            }
        }
    }
    for (int i : vis) dist[i] = -1;
    vis.clear();
    return ans;
}