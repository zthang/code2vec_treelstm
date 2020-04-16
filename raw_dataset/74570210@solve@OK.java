public static void solve(InputReader in, PrintWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    graph = new HashMap<>(n);
    for (int i = 0; i < n - 1; ++i) {
        int from = in.nextInt();
        int to = in.nextInt();
        if (graph.containsKey(from)) {
            graph.get(from).add(to);
        } else {
            List<Integer> v = new ArrayList<>();
            v.add(to);
            graph.put(from, v);
        }
        if (graph.containsKey(to)) {
            graph.get(to).add(from);
        } else {
            List<Integer> v = new ArrayList<>();
            v.add(from);
            graph.put(to, v);
        }
    }
    heights = new HashMap<>();
    visited = new HashSet<>();
    parents = new HashMap<>(n);
    tin = new int[n + 1];
    tout = new int[n + 1];
    dfs(1, 1);
    for (int i = 0; i < m; ++i) {
        int k = in.nextInt();
        List<Integer> v = new ArrayList<>(k);
        for (int j = 0; j < k; ++j) {
            v.add(in.nextInt());
        }
        v.sort(Comparator.comparingInt(heights::get));
        int j = 0;
        if (v.get(j) == 1)
            j++;
        boolean good = true;
        for (; j < k - 1; ++j) {
            int v1 = parents.get(v.get(j));
            int v2 = parents.get(v.get(j + 1));
            if (!(tin[v1] <= tin[v2] && tout[v1] >= tout[v2])) {
                good = false;
                break;
            }
        }
        out.println(good ? "YES" : "NO");
    }
}