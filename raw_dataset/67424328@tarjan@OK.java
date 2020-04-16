void tarjan(int u, int fa) {
    int child = 0;
    dfn[u] = ++deep;
    low[u] = deep;
    vis[u] = true;
    stack[++top] = u;
    int sz = g[u].size();
    for (int i = 0; i < sz; i++) {
        int v = g[u].get(i);
        if (v == fa)
            continue;
        if (dfn[v] == 0) {
            child++;
            tarjan(v, u);
            low[u] = Math.min(low[u], low[v]);
        } else {
            if (vis[v]) {
                low[u] = Math.min(low[u], low[v]);
            }
        }
    }
    if (fa < 0 && child == 1) {
        iscut[u] = true;
    }
    if (dfn[u] == low[u]) {
        iscut[u] = true;
        color[u] = ++sum;
        vis[u] = false;
        while (stack[top] != u) {
            color[stack[top]] = sum;
            vis[stack[top--]] = false;
        }
        top--;
    }
}