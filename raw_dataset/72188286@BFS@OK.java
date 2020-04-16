// <>
static void BFS() {
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(arr[k - 1]);
    int s;
    while (q.size() != 0) {
        s = q.remove();
        vis[s] = true;
        for (int e : adj[s]) {
            if (!vis[e]) {
                vis[e] = true;
                q.add(e);
                depth[e] = depth[s] + 1;
                cnt[e] = 1;
            } else if (depth[e] == depth[s] + 1) {
                cnt[e]++;
            } else if (depth[e] > depth[s] + 1) {
                cnt[e] = 1;
                depth[e] = depth[s] + 1;
            }
        }
    }
}