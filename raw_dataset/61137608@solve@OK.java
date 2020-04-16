void solve() throws Exception {
    int i, j, k;
    N = hp.nextInt();
    M = hp.nextInt();
    edges = new int[M][];
    for (i = 0; i < M; ++i) {
        edges[i] = new int[] { hp.nextInt() - 1, hp.nextInt() - 1 };
    }
    graph = new ArrayList[N];
    for (i = 0; i < N; ++i) graph[i] = new ArrayList<>();
    for (int[] e : edges) {
        graph[e[0]].add(e[1]);
        graph[e[1]].add(e[0]);
    }
    int ans = 0;
    int[] cols = new int[N];
    HashSet<String> added;
    while (true) {
        int temp = 0;
        added = new HashSet<>();
        for (int[] e : edges) {
            int c1 = cols[e[0]], c2 = cols[e[1]];
            int mn = Math.min(c1, c2), mx = Math.max(c1, c2);
            String t = mn + " " + mx;
            if (!added.contains(t)) {
                ++temp;
                added.add(t);
            }
        }
        ans = Math.max(ans, temp);
        ++cols[0];
        for (i = 0; i < N - 1 && cols[i] >= 6; ++i) {
            cols[i] = 0;
            ++cols[i + 1];
        }
        if (cols[i] >= 6)
            break;
    }
    hp.println(ans);
    hp.flush();
}