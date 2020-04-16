public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt(), M = in.nextInt();
    Nodes[] nodes = new Nodes[N];
    for (int i = 0; i < N; i++) {
        nodes[i] = new Nodes(i);
    }
    Edges[] edges = new Edges[M];
    for (int i = 0; i < M; i++) {
        int u = in.nextInt() - 1, v = in.nextInt() - 1;
        Edges e = new Edges(u, nodes[v], i);
        edges[i] = e;
        nodes[u].edges.add(e);
        nodes[v].degree++;
    }
    ans = 1;
    for (int i = 0; i < N; i++) {
        if (nodes[i].color == 0) {
            dfs(nodes[i]);
        }
    }
    out.printLine(ans);
    for (int i = 0; i < M; i++) {
        out.print(edges[i].isBack + " ");
    }
}