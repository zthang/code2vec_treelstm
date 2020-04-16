public void dfs(int x, int p) {
    prr[x] = p;
    in[x] = time++;
    for (int y : adj[x]) {
        if (y != p)
            dfs(y, x);
    }
    out[x] = ++time;
}