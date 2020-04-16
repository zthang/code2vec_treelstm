static void dfs(int node, int p) {
    subSz[node] = 1;
    for (Edge e : adj[node]) {
        if (e.to == p)
            continue;
        dfs(e.to, node);
        worstCase += e.c * Math.min(subSz[e.to], N - subSz[e.to]);
        if (subSz[e.to] % 2 != 0 || (N - subSz[e.to]) % 2 != 0)
            bestCase += e.c;
        subSz[node] += subSz[e.to];
    }
}