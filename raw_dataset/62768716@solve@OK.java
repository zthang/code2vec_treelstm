public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    color = new int[n];
    int[][] cost = new int[3][];
    for (int i = 0; i < 3; i++) {
        cost[i] = in.nextInts(n);
    }
    graph = new Graph(n);
    for (int i = 1; i < n; i++) {
        int u = in.nextInt() - 1;
        int v = in.nextInt() - 1;
        graph.addEdge(u, v);
        graph.addEdge(v, u);
    }
    for (int i = 0; i < n; i++) {
        if (graph.adjSize(i) >= 3) {
            out.println(-1);
            return;
        }
    }
    long result = Long.MAX_VALUE;
    int[] resultColor = new int[0];
    int first = 0, second = graph.adj(first).iterator().next();
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (i == j) {
                continue;
            }
            Arrays.fill(color, -1);
            color[first] = i;
            color[second] = j;
            dfs(first, second);
            dfs(second, first);
            long sum = 0;
            for (int k = 0; k < n; k++) {
                sum += cost[color[k]][k];
            }
            if (sum < result) {
                result = sum;
                resultColor = Arrays.copyOf(color, n);
            }
        }
    }
    if (result != Long.MAX_VALUE) {
        out.println(result);
        for (int i = 0; i < n; i++) {
            resultColor[i]++;
        }
        out.printInts(resultColor);
    } else {
        out.println(-1);
    }
}