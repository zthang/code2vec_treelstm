void dfs(int node, int par) {
    dfsNum[node] = low[node] = num++;
    vis[node] = 1;
    int nChild = 0;
    for (Edge e : adj[node]) {
        if (e.v == par)
            continue;
        if (vis[e.v] == 0) {
            ++nChild;
            eStack.push(e);
            dfs(e.v, node);
            low[node] = Math.min(low[node], low[e.v]);
            if (low[e.v] >= dfsNum[node]) {
                if (dfsNum[node] > 0 || nChild > 1)
                    cuts.add(node);
                if (low[e.v] > dfsNum[node]) {
                    bridges.add(e);
                    pop(node);
                } else
                    pop(node);
            }
        } else if (vis[e.v] == 1) {
            low[node] = Math.min(low[node], dfsNum[e.v]);
            eStack.push(e);
        }
    }
    vis[node] = 2;
}