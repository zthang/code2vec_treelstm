public void solve(int testNumber, FastScanner in, PrintWriter out) {
    int n = in.nextInt(), m = in.nextInt();
    graph = Utils.listArray(n);
    revGraph = Utils.listArray(n);
    for (int i = 0; i < m; i++) {
        int from = in.nextInt() - 1, to = in.nextInt() - 1;
        graph[from].add(to);
        revGraph[to].add(from);
    }
    int k = in.nextInt();
    int[] path = in.nextIntArray(k);
    for (int i = 0; i < k; i++) {
        path[i]--;
    }
    int[] d1 = dist(graph, path[0]);
    int[] d2 = dist(revGraph, path[k - 1]);
    int[] countEdges = new int[n];
    for (int from = 0; from < n; from++) {
        for (int to : graph[from]) {
            if (d2[from] == d2[to] + 1) {
                countEdges[from]++;
            }
        }
    }
    int min = 0, max = 0;
    for (int i = 0; i < k - 1; i++) {
        int from = path[i], to = path[i + 1];
        if (d2[from] != d2[to] + 1) {
            min++;
            max++;
        } else {
            if (countEdges[from] > 1) {
                max++;
            }
        }
    }
    out.println(min + " " + max);
}