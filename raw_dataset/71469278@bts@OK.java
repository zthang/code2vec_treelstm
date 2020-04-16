public static int[] bts(int start, int N, LinkedList<Integer>[] edges) {
    int[] dist = new int[N + 1];
    Arrays.fill(dist, 2 * N);
    // start is always N
    dist[start] = 0;
    Queue<Integer> q = new LinkedList<Integer>();
    int[] par = new int[N + 1];
    par[start] = -1;
    q.add(start);
    while (q.size() > 0) {
        int curr = q.poll();
        for (int next : edges[curr]) if (dist[next] > dist[curr] + 1) {
            dist[next] = dist[curr] + 1;
            q.add(next);
            par[next] = curr;
        }
    }
    return dist;
}