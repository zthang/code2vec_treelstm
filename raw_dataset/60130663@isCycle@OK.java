static void isCycle(int u) {
    if (cycle)
        return;
    inStack[u] = true;
    vis[u] = true;
    for (int v : g[u]) {
        if (inStack[v]) {
            cycle = true;
            return;
        } else if (!vis[v])
            isCycle(v);
    }
    inStack[u] = false;
}