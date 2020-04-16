private static void dfs(int u, int prev, long curCost) {
    List<Integer> next = edges[u];
    if ((prev < 0 && next == null) || (prev >= 0 && next.size() == 1)) {
        maxLine = Math.max(maxLine, curCost + weight[u]);
        return;
    }
    visit[u] = true;
    curCost += weight[u];
    for (int v : next) {
        if (v == prev)
            continue;
        if (visit[v]) {
            circle[u] = true;
            circleExist = true;
        } else {
            if (!circle[v])
                dfs(v, u, curCost);
            if (circle[v])
                circle[u] = true;
        }
    }
    curCost -= weight[u];
    visit[u] = false;
}