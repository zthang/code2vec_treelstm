public static int[] bfs(ArrayList<Integer>[] a, int start) {
    ArrayDeque<Integer> q = new ArrayDeque<>();
    int[] dist = new int[a.length];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;
    q.offer(start);
    while (!q.isEmpty()) {
        int c = q.poll();
        for (int nxt : a[c]) {
            if (dist[nxt] == Integer.MAX_VALUE) {
                dist[nxt] = dist[c] + 1;
                q.offer(nxt);
            }
        }
    }
    return dist;
}