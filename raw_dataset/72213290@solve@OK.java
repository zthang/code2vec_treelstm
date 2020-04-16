public void solve(int testNumber, InputReader in, PrintWriter out) {
    int N = in.nextInt();
    int M = in.nextInt();
    int[] cnt = new int[N];
    int[] dist = new int[N];
    ArrayList<Integer>[] adj = new ArrayList[N];
    for (int i = 0; i < N; i++) {
        adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < M; i++) {
        int u = in.nextInt() - 1;
        int v = in.nextInt() - 1;
        adj[v].add(u);
    }
    int k = in.nextInt();
    int[] path = new int[k];
    Arrays.fill(dist, (int) (1e9));
    for (int i = 0; i < k; i++) {
        path[i] = in.nextInt() - 1;
    }
    dist[path[k - 1]] = 0;
    cnt[path[k - 1]] = 1;
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    deque.add(path[k - 1]);
    boolean[] m = new boolean[N];
    while (!deque.isEmpty()) {
        int next = deque.remove();
        for (int e : adj[next]) {
            if (dist[e] > dist[next] + 1) {
                dist[e] = dist[next] + 1;
                cnt[e] = cnt[next];
                deque.add(e);
            } else if (dist[e] == dist[next] + 1) {
                m[e] = true;
                cnt[e] += cnt[next];
            }
        }
    }
    int min = 0;
    int max = 0;
    for (int i = 1; i < k; i++) {
        if (dist[path[i - 1]] != dist[path[i]] + 1) {
            min++;
            max++;
        } else if (m[path[i - 1]]) {
            max++;
        }
    }
    out.println(min + " " + max);
}