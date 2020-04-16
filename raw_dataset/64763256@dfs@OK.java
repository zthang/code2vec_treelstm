static void dfs(int v) {
    vis[v] = true;
    for (int e : adj[v]) {
        if (!vis[e]) {
            dfs(e);
        }
    }
    st.add(v);
}