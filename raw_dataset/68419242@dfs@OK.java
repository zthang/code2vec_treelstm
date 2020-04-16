static void dfs(int v, int p) {
    ArrayList<Integer> f = new ArrayList<>();
    for (int i = 0; i <= c[v]; i++) {
        f.add(st.pollFirst());
    }
    ans[v] = f.get(f.size() - 1);
    for (int i = 0; i < f.size() - 1; i++) {
        st.add(f.get(i));
    }
    for (int to : g[v]) if (to != p)
        dfs(to, v);
}