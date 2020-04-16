public static void dfs(int cur, int par) {
    max[cur] = w[cur];
    for (int z : adj[cur]) {
        if (z == par)
            continue;
        if (vis[z]) {
            loop[z] = true;
            loop[cur] = true;
            continue;
        }
        vis[z] = true;
        dfs(z, cur);
        if (loop[z])
            loop[cur] = true;
        else {
            max[cur] = Math.max(max[cur], w[cur] + max[z]);
        }
    }
    if (loop[cur])
        ans += w[cur];
    else
        tmax = Math.max(tmax, max[cur]);
}