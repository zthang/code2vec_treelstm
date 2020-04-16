private int getCircleLength(int start) {
    int ans = INF;
    primeSet.forEach(i -> dist[i] = INF);
    dist[start] = 0;
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(start);
    while (!queue.isEmpty()) {
        int now = queue.poll();
        // debug(now, dist[now], path[now]);
        for (int next : path[now]) {
            if (dist[next] >= dist[now]) {
                ans = Math.min(ans, dist[next] + dist[now] + 1);
            // debug(next, dist[next], ans);
            }
            if (dist[next] > dist[now] + 1) {
                dist[next] = dist[now] + 1;
                queue.add(next);
            }
        }
    }
    return ans;
}