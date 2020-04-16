public static int[] dijkstra(ArrayList<Edge>[] adjlist, int N, int s) {
    int[] dist = new int[N];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[s] = 0;
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
    pq.add(new Pair(0, s));
    while (!pq.isEmpty()) {
        Pair curr = pq.poll();
        int ind = curr.ind;
        if (curr.d > dist[ind]) {
            continue;
        }
        for (Edge p : adjlist[ind]) {
            int v = p.i == ind ? p.j : p.i;
            int d = p.w;
            if (dist[v] > curr.d + d) {
                dist[v] = curr.d + d;
                pq.add(new Pair(dist[v], v));
            }
        }
    }
    return dist;
}