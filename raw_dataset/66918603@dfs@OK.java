static void dfs(int node, int p) {
    par[node] = p;
    int sz = adj[node].size();
    if (p != -1)
        sz--;
    child[node] = new Edge[sz];
    int idd = 0;
    subSz[node] = 1;
    for (Edge e : adj[node]) {
        if (e.to == p)
            continue;
        child[node][idd++] = e;
        dfs(e.to, node);
        worstCase += e.c * min(subSz[e.to], N - subSz[e.to]);
        subSz[node] += subSz[e.to];
    }
}