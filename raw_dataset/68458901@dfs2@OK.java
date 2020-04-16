static void dfs2(int v) {
    int x = c[v] + 1;
    ans[v] = st.kth(x) + 1;
    st.upd(ans[v] - 1, 0);
    for (int u : g[v]) {
        dfs2(u);
    }
}