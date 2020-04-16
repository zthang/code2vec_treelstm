void kruskal() {
    for (int i = 0; i < arr1.length; i++) if (!vis[arr1[i]])
        DFS(arr1[i], true, false);
    graph rev = this.getRev();
    while (!st.isEmpty()) {
        int u = st.pop();
        if (!rev.vis[u]) {
            rev.DFS(u, false, true);
            while (!rev.q.isEmpty()) {
                diff[rev.q.poll()] = Math.min(SCC, k - 1);
            }
            SCC++;
        }
    }
}