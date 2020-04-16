void solve() throws Exception {
    int i, j, k;
    N = hp.nextInt();
    M = hp.nextInt();
    graph = new ArrayList[N];
    for (i = 0; i < N; ++i) graph[i] = new ArrayList<>();
    edges = new int[M][];
    contains = new int[N + 7][N + 7][];
    for (i = 0; i < M; ++i) {
        edges[i] = new int[] { hp.nextInt() - 1, hp.nextInt() - 1, -7 };
        contains[edges[i][0]][edges[i][1]] = edges[i];
    }
    // mem = new int[N + 7];
    hp.println(bs());
    for (int[] e : edges) hp.print(e[2] + " ");
    hp.flush();
}