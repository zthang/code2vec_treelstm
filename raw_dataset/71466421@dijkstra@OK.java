public static int[] dijkstra(ArrayList<Edge>[] adjlist, int N, int s) {
    int[] dist = new int[N];
    int done = 0;
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[s] = 0;
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
    pq.add(new Pair(0, s));
    while (!pq.isEmpty()) {
        if (done == N)
            return dist;
        Pair curr = pq.poll();
        int ind = curr.ind;
        for (Edge p : adjlist[ind]) {
            int v = p.i == ind ? p.j : p.i;
            if (dist[v] == Integer.MAX_VALUE) {
                dist[v] = curr.d + 1;
                pq.add(new Pair(dist[v], v));
            }
        }
    }
    return dist;
}