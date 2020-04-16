public void solve(int testNumber, InputReader in, OutputWriter out) {
    N = in.nextInt();
    int M = in.nextInt();
    graph = new HashSet[N];
    set = new TreeSet<>();
    for (int i = 0; i < N; i++) {
        graph[i] = new HashSet<>();
        set.add(i);
    }
    for (int i = 0; i < M; i++) {
        int u = in.nextInt() - 1, v = in.nextInt() - 1;
        graph[u].add(v);
        graph[v].add(u);
    }
    int ans = 0;
    for (int i = 0; i < N; i++) {
        if (set.contains(i)) {
            ans++;
            dfs(i);
        }
    }
    out.printLine(ans - 1);
}