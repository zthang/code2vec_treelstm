public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt(), M = in.nextInt();
    GraphUtils graph = new GraphUtils();
    graph.initGraph(N, new String[N]);
    Integer[] score = in.nextIntArray(N);
    for (int i = 0; i < M; i++) {
        graph.addEdge(in.nextInt() - 1, in.nextInt() - 1, false, 1);
    }
    int source = in.nextInt() - 1;
    int[] degree = new int[N];
    Queue<GraphUtils.Node> queue = new LinkedList<>();
    for (GraphUtils.Node node : graph.nodes) {
        degree[node.index] = node.edges.size();
        if (node.index != source && degree[node.index] == 1) {
            ((LinkedList<GraphUtils.Node>) queue).add(node);
        }
    }
    long[] best = new long[N];
    while (!queue.isEmpty()) {
        GraphUtils.Node node = queue.poll();
        degree[node.index] = -1;
        for (GraphUtils.Edge edge : node.edges) {
            GraphUtils.Node v = edge.to;
            if (degree[v.index] < 0) {
                continue;
            }
            degree[v.index]--;
            best[v.index] = Math.max(best[v.index], best[node.index] + score[node.index]);
            if (degree[v.index] == 1 && v.index != source) {
                ((LinkedList<GraphUtils.Node>) queue).add(v);
            }
        }
    }
    long total = 0, maxInsert = 0;
    for (int i = 0; i < N; i++) {
        if (degree[i] < 0) {
            continue;
        }
        total += score[i];
        maxInsert = Math.max(maxInsert, best[i]);
    }
    out.printLine(total + maxInsert);
}