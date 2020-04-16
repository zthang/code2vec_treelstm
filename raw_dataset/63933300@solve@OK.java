public void solve() {
    int n = in.ni(), m = in.ni();
    color = new int[m];
    node = new int[n];
    visited = new boolean[n];
    graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
        int u = in.ni() - 1, v = in.ni() - 1;
        graph.get(u).add(new Edge(i, v));
    }
    for (int u = 0; u < n; u++) {
        if (!visited[u]) {
            dfs(u);
        }
    }
    out.println(cycle ? 2 : 1);
    for (int i = 0; i < m; i++) {
        out.print(color[i]);
        out.print(' ');
    }
}