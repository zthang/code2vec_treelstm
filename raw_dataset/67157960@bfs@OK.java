static int[] bfs(ArrayList<Integer>[] adj, int n, ArrayList<Integer> arr) {
    int[] vis = new int[n];
    int[] dis = new int[n];
    int[] par = new int[n];
    Queue<Integer> q = new LinkedList<>();
    Arrays.fill(dis, -1);
    for (int i = 0; i < arr.size(); i++) {
        vis[arr.get(i)] = 1;
        dis[arr.get(i)] = 0;
        par[arr.get(i)] = -1;
        q.add(arr.get(i));
    }
    while (!q.isEmpty()) {
        int x = q.remove();
        for (int u : adj[x]) {
            if (vis[u] == 0) {
                vis[u] = 1;
                dis[u] = dis[x] + 1;
                par[u] = x;
                q.add(u);
            }
        }
    }
    return dis;
}