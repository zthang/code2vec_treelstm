public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    ArrayList<Integer> inDegrees = new ArrayList<>();
    List<List<Integer>> adj = new ArrayList<>();
    ArrayList<List<Integer>> edges = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
        adj.add(new ArrayList<>());
        inDegrees.add(0);
    }
    for (int i = 1; i <= m; i++) {
        int u = in.nextInt();
        int v = in.nextInt();
        edges.add(Arrays.asList(u, v));
        adj.get(u).add(v);
        inDegrees.set(v, inDegrees.get(v) + 1);
    }
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    for (int u = 1; u <= n; u++) {
        if (inDegrees.get(u) == 0) {
            queue.addLast(u);
        }
    }
    ArrayList<Integer> topsort = new ArrayList<>();
    while (!queue.isEmpty()) {
        int u = queue.pollFirst();
        topsort.add(u);
        for (Integer v : adj.get(u)) {
            inDegrees.set(v, inDegrees.get(v) - 1);
            if (inDegrees.get(v) == 0) {
                queue.addLast(v);
            }
        }
    }
    if (topsort.size() == n) {
        out.println(1);
        for (int i = 0; i < m; i++) {
            out.printf("1 ");
        }
        out.println();
    } else {
        out.println(2);
        for (List<Integer> edge : edges) {
            if (edge.get(0) < edge.get(1)) {
                out.printf("1 ");
            } else {
                out.printf("2 ");
            }
        }
        out.println();
    }
}