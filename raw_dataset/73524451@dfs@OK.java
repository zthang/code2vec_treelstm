static void dfs(int node, int par, int d) {
    dPar[node] = par;
    dep[node] = d;
    vis[node] = true;
    for (int ii : adj[node]) {
        if (ii == par || vis[ii])
            continue;
        dChild[node].add(ii);
        dfs(ii, node, d + 1);
    }
}