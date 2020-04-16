public void solve(int testNumber, inputClass sc, PrintWriter out) {
    int n = sc.nextInt();
    graph = new DHarmoniousGraph.Node[n];
    for (int i = 0; i < n; i++) {
        graph[i] = new DHarmoniousGraph.Node();
        graph[i].edges = new ArrayList<>();
    }
    int m = sc.nextInt();
    for (int i = 0; i < m; i++) {
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        graph[x].edges.add(y);
        graph[y].edges.add(x);
    }
    visited = new boolean[n];
    ArrayList<DHarmoniousGraph.Pair> inter = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            min = Integer.MAX_VALUE;
            max = -1;
            dfs(i);
            inter.add(new DHarmoniousGraph.Pair(min, max));
        }
    }
    inter.sort(Comparator.comparingInt(a -> a.x));
    int ans = 0;
    int last = inter.get(0).y;
    for (int i = 1; i < inter.size(); i++) {
        if (inter.get(i).x < last) {
            ans++;
        }
        last = Math.max(inter.get(i).y, last);
    }
    out.println(ans);
}