private List<Integer> dfs(int v, int p) {
    List<Integer> all = new ArrayList<>();
    for (int u : adj[v]) {
        if (u == p) {
            continue;
        }
        List<Integer> ch = dfs(u, v);
        if (ch == null) {
            return null;
        }
        all.addAll(ch);
    }
    if (c[v] > all.size()) {
        return null;
    }
    all.add(c[v], v);
    return all;
}