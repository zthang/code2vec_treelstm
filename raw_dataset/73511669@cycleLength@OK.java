private static int cycleLength(int u) {
    vis.clear();
    vis.add(u);
    dist[u] = 0;
    int ans = -1;
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(u);
    while (ans == -1 && !queue.isEmpty()) {
        int v = queue.poll();
        for (int child : edge[v]) {
            if (dist[child] == -1) {
                dist[child] = dist[v] + 1;
                parent[child] = v;
                vis.add(child);
                queue.add(child);
            } else if (parent[v] != child) {
                ans = dist[v] + dist[child] + 1;
                break;
            }
        }
    }
    for (int i : vis) dist[i] = -1;
    return ans;
}