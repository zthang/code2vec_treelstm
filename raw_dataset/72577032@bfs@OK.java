private int[] bfs(int start) {
    int[] dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE / 3);
    ArrayDeque<Integer> search = new ArrayDeque<>();
    search.add(start);
    dist[start] = 0;
    while (!search.isEmpty()) {
        int v = search.poll();
        for (int neigh : graph[v]) {
            if (dist[v] + 1 < dist[neigh]) {
                search.add(neigh);
                dist[neigh] = dist[v] + 1;
            } else if (dist[v] + 1 == dist[neigh]) {
                mult[neigh]++;
            }
        }
    }
    return dist;
}