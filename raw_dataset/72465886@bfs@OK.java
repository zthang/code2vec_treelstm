static int bfs(int node, int n) {
    int ans = 0;
    boolean f = false;
    boolean[] vis = new boolean[n];
    Queue<Integer> q = new LinkedList<Integer>();
    for (int i = 1; i < n; i++) {
        if (arr[i].size() == 1) {
            q.add(i);
            vis[i] = true;
        }
    }
    while (!q.isEmpty()) {
        if (f)
            ans += q.size();
        f = !f;
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int u = q.remove();
            for (int v : arr[u]) if (!vis[v]) {
                vis[v] = true;
                q.add(v);
            }
        }
    }
    return ans;
}