public void solve(int testNumber, InputReader in, PrintWriter out) {
    int N = in.nextInt();
    adj = new ArrayList[N];
    for (int i = 0; i < N; i++) {
        adj[i] = new ArrayList<>();
    }
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
        int a = in.nextInt();
        arr[i] = a;
        if (i + a < N) {
            adj[i + a].add(i);
        }
        if (i - a >= 0) {
            adj[i - a].add(i);
        }
    }
    int[] dist = new int[N];
    boolean[] visited;
    for (int j = 0; j < 2; j++) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] curDist = new int[N];
        Arrays.fill(curDist, INF);
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == j) {
                queue.add(i);
                curDist[i] = 0;
            }
        }
        while (!queue.isEmpty()) {
            int next = queue.remove();
            for (int c : adj[next]) {
                if (curDist[next] + 1 < curDist[c]) {
                    curDist[c] = curDist[next] + 1;
                    queue.add(c);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 != j) {
                dist[i] = (curDist[i] == INF ? -1 : curDist[i]);
            }
        }
    }
    for (int i = 0; i < N; i++) {
        out.print(dist[i] + " ");
    }
}