static int[] bfs(int s) {
    int[] dist = new int[adjList.length];
    Arrays.fill(dist, -1);
    dist[s] = 0;
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(s);
    while (!q.isEmpty()) {
        int cur = q.poll();
        for (int x : adjList[cur]) {
            if (dist[x] == -1) {
                dist[x] = dist[cur] + 1;
                q.add(x);
            }
        }
    }
    return dist;
}