private int[] bfs(int start) {
    int[] dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE / 3);
    boolean[] vis = new boolean[V];
    ArrayDeque<Integer> search = new ArrayDeque<>();
    search.add(start);
    dist[start] = 0;
    vis[start] = true;
    while (!search.isEmpty()) {
        int v = search.poll();
        for (int neigh : graph[v]) {
            if (!vis[neigh]) {
                search.add(neigh);
                dist[neigh] = dist[v] + 1;
                vis[neigh] = true;
            } else if (dist[v] + 1 == dist[neigh]) {
                mult[neigh]++;
            }
        }
    }
    return dist;
}