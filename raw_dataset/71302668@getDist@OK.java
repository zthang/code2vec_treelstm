int[] getDist(int source) {
    int[] dist = new int[n];
    Arrays.fill(dist, 1 << 30);
    dist[source] = 0;
    int front = 0, back = 0;
    int[] q = new int[n];
    q[back++] = source;
    while (front < back) {
        int cur = q[front++];
        for (int nxt : graph[cur]) {
            if (dist[cur] + 1 < dist[nxt]) {
                dist[nxt] = dist[cur] + 1;
                q[back++] = nxt;
            }
        }
    }
    return dist;
}