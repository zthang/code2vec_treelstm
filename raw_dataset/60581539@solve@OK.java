public void solve(int testNumber, inputClass sc, PrintWriter out) {
    int n = sc.nextInt();
    int k = sc.nextInt();
    graph = new DCowAndSnacks.Node[n];
    ans = 0;
    done = new HashMap<>();
    visited = new boolean[n];
    HashMap<DCowAndSnacks.Pair, Integer> saye = new HashMap<>();
    for (int i = 0; i < n; i++) {
        graph[i] = new DCowAndSnacks.Node();
        graph[i].edges = new ArrayList<>();
    }
    for (int i = 0; i < k; i++) {
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        DCowAndSnacks.Pair p;
        if (x > y) {
            p = new DCowAndSnacks.Pair(y, x, 0);
        } else {
            p = new DCowAndSnacks.Pair(x, y, 0);
        }
        if (saye.get(p) != null) {
            ans++;
            continue;
        }
        graph[x].edges.add(y);
        graph[y].edges.add(x);
        saye.put(p, 1);
    }
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs(i, -1);
        }
    }
    out.println(ans);
}