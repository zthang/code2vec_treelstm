public static void solve(FastIO io) {
    int N = io.nextInt();
    int M = io.nextInt();
    Node[] nodes = new Node[N + 1];
    for (int i = 1; i <= N; ++i) {
        nodes[i] = new Node(i);
    }
    for (int i = 0; i < M; ++i) {
        int U = io.nextInt();
        int V = io.nextInt();
        nodes[V].next.add(nodes[U]);
    }
    int K = io.nextInt();
    int[] P = io.nextIntArray(K);
    int[] wantNodeID = new int[N + 1];
    for (int i = 1; i < K; ++i) {
        wantNodeID[P[i - 1]] = P[i];
    }
    int target = P[K - 1];
    Queue<Integer> q = new ArrayDeque<>();
    int[] best = new int[N + 1];
    boolean[] gotWant = new boolean[N + 1];
    boolean[] gotOther = new boolean[N + 1];
    Arrays.fill(best, INF);
    q.offer(target);
    q.offer(0);
    best[target] = 0;
    while (!q.isEmpty()) {
        int uid = q.poll();
        int d = q.poll();
        Node u = nodes[uid];
        for (Node v : u.next) {
            int vid = v.id;
            if (best[vid] < d + 1) {
                continue;
            }
            if (wantNodeID[vid] == uid) {
                gotWant[vid] = true;
            } else {
                gotOther[vid] = true;
            }
            if (best[vid] <= d + 1) {
                continue;
            }
            best[vid] = d + 1;
            q.offer(vid);
            q.offer(d + 1);
        }
    }
    int minCount = 0;
    int maxCount = 0;
    for (int i = 0; i < K - 1; ++i) {
        if (gotWant[P[i]] && gotOther[P[i]]) {
            ++maxCount;
        } else if (gotOther[P[i]]) {
            ++minCount;
            ++maxCount;
        }
    }
    io.println(minCount, maxCount);
}