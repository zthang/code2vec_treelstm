long solve() throws IOException {
    int n = sc.nextInt(), m = sc.nextInt();
    graph = new List[n + 1];
    for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
    for (int i = 0; i < m; i++) {
        int u = sc.nextInt(), v = sc.nextInt();
        // we want to reversely search. t as the source of BFS
        graph[v].add(u);
    }
    int inf = 1234567;
    int[] dist = new int[n + 1];
    Arrays.fill(dist, inf);
    int k = sc.nextInt();
    int[] p = new int[k + 1];
    for (int i = 1; i <= k; i++) p[i] = sc.nextInt();
    int start = p[k], step = 1;
    dist[start] = 0;
    List<Integer> cur = new LinkedList<>(), next = new LinkedList<>();
    cur.add(start);
    Set<Integer>[] prev = new Set[n + 1], toWards = new Set[n + 1];
    for (int i = 0; i <= n; i++) {
        prev[i] = new HashSet<>();
        toWards[i] = new HashSet<>();
    }
    // bfs
    while (cur.size() > 0) {
        for (int now : cur) {
            for (int to : graph[now]) {
                if (dist[to] < step)
                    continue;
                if (dist[to] == step) {
                    prev[now].add(to);
                    toWards[to].add(now);
                } else {
                    dist[to] = step;
                    // prev[to].clear();
                    toWards[to].add(now);
                    prev[now].add(to);
                    next.add(to);
                }
            }
        }
        cur = next;
        next = new LinkedList<>();
        step++;
    }
    int mini = 0, maxi = 0;
    for (int i = 1; i < k; i++) {
        int now = p[i], to = p[i + 1];
        if (!toWards[now].contains(to)) {
            mini++;
            maxi++;
        } else {
            boolean flag = false;
            for (int w : toWards[now]) {
                flag |= (w != to);
                if (flag)
                    break;
            }
            if (flag)
                maxi++;
        }
    }
    System.out.println(String.format("%d %d", mini, maxi));
    return 0;
}