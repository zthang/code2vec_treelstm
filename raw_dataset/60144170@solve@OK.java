public void solve(int testNumber, inputClass sc, PrintWriter out) {
    int n = sc.nextInt();
    graph = new DColoringEdges.Node[n];
    visited = new boolean[n];
    stack = new boolean[n];
    for (int i = 0; i < n; i++) {
        graph[i] = new DColoringEdges.Node();
        graph[i].edges = new ArrayList<>();
    }
    int m = sc.nextInt();
    for (int i = 0; i < m; i++) {
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        graph[x].edges.add(new DColoringEdges.Pair(y, i));
    }
    ans = new int[m];
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs(i);
        }
    }
    int max = 0;
    for (int i : ans) max = Math.max(max, i);
    out.println(max);
    for (int i : ans) {
        out.print(i + " ");
    }
}