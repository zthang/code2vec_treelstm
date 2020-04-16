static void dfsCnt(int i, int par) {
    for (int u : adj[i]) {
        if (u != par) {
            dfsCnt(u, i);
            cnt[i] += Math.max(cnt[u], 0);
        }
    }
    cnt[i] += a[i];
}