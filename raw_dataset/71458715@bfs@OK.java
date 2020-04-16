private static int bfs(List<Integer>[] adj, int src, boolean[] visited, int[] color) {
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(src);
    visited[src] = true;
    int blueCount = 1;
    int redCount = 0;
    // 1: blue, 2: red
    color[src] = 1;
    while (!queue.isEmpty()) {
        int u = queue.remove();
        for (Integer v : adj[u]) {
            if (!visited[v]) {
                visited[v] = true;
                queue.add(v);
                if (color[u] == 1) {
                    redCount++;
                    color[v] = 2;
                } else if (color[u] == 2) {
                    blueCount++;
                    color[v] = 1;
                }
            }
        }
    }
    return max(blueCount, redCount);
}