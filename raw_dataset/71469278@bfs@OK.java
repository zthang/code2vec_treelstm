public static ArrayList<Integer> bfs(int start, int N, LinkedList<Integer>[] edges, int[] specs) {
    boolean[] special = new boolean[N + 5];
    for (int x : specs) special[x] = true;
    // bfs
    int[] dist = new int[N + 1];
    Arrays.fill(dist, 2 * N);
    // start is always 1
    dist[start] = 0;
    Queue<Integer> q = new LinkedList<Integer>();
    int[] par = new int[N + 1];
    par[start] = -1;
    q.add(start);
    while (q.size() > 0) {
        int curr = q.poll();
        for (int next : edges[curr]) {
            if (dist[next] > dist[curr] + 1) {
                dist[next] = dist[curr] + 1;
                q.add(next);
                par[next] = curr;
            }
            if (dist[next] == dist[curr] + 1 && special[par[next]] && !special[curr]) {
                // dist[next] = dist[curr]+1;
                // q.add(next);
                par[next] = curr;
            }
        }
    }
    ArrayList<Integer> ls = new ArrayList<Integer>();
    ls.add(N);
    int boof = par[N];
    while (boof != -1) {
        ls.add(boof);
        boof = par[boof];
    }
    Collections.reverse(ls);
    return ls;
}