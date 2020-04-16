public static void solve() {
    int n = s.nextInt();
    int m = s.nextInt();
    int k = s.nextInt();
    adj = new LinkedList[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new LinkedList<Integer>();
    }
    int[] special = new int[k];
    for (int i = 0; i < k; i++) {
        special[i] = s.nextInt() - 1;
    }
    while (m-- > 0) {
        int u = s.nextInt() - 1;
        int v = s.nextInt() - 1;
        adj[u].add(v);
        adj[v].add(u);
    }
    int[] x = new int[n];
    int[] y = new int[n];
    Bfs(0, x);
    Bfs(n - 1, y);
    ArrayList<Pair> nodes = new ArrayList<Pair>();
    for (int i = 0; i < k; i++) {
        nodes.add(new Pair(x[special[i]], y[special[i]]));
    }
    Collections.sort(nodes);
    int maxy = nodes.get(k - 1).y;
    int max = 0;
    for (int i = k - 2; i >= 0; i--) {
        max = Integer.max(max, nodes.get(i).x + maxy + 1);
        maxy = Integer.max(maxy, nodes.get(i).y);
    }
    out.println(Integer.min(max, x[n - 1]));
}