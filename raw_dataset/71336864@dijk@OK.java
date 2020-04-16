int[] dijk(int src) {
    boolean[] visited = new boolean[N];
    PriorityQueue<State> queue = new PriorityQueue<>(new Comparator<State>() {

        public int compare(State state, State t1) {
            return Integer.compare(state.d, t1.d);
        }
    });
    int[] dist = new int[N];
    Arrays.fill(dist, (int) (1e9));
    dist[src] = 0;
    queue.add(new State(0, src));
    int done = 1;
    while (done != N) {
        State next = queue.remove();
        if (!visited[next.i]) {
            visited[next.i] = true;
            done++;
            for (int e : adj[next.i]) {
                if (dist[e] > dist[next.i] + 1) {
                    dist[e] = dist[next.i] + 1;
                    queue.add(new State(dist[e], e));
                }
            }
        }
    }
    return dist;
}