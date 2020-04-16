private static long getAddCost(int u) {
    List<Integer> next = edges[u];
    if (next == null || next.isEmpty()) {
        return circle[u] ? 0 : weight[u];
    }
    visit[u] = true;
    long max = 0;
    for (int v : next) {
        if (circle[v] || visit[v])
            continue;
        max = Math.max(max, getAddCost(v));
    }
    visit[u] = false;
    return max + (circle[u] ? 0 : weight[u]);
}