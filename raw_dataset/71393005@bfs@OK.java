static boolean bfs(int s) {
    int[] visited = new int[V];
    boolean flag = false;
    dist = new int[V];
    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    visited[s] = 1;
    while (!q.isEmpty()) {
        s = q.poll();
        for (Integer x : graph[s]) {
            if (visited[x] == 1)
                continue;
            q.add(x);
            dist[x] = 1 + dist[s];
            visited[x] = 1;
            if (map.get(s) != null && map.get(x) != null)
                flag = true;
        }
    }
    return flag;
}