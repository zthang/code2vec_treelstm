public static void solve() {
    int n = s.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) a[i] = s.nextInt();
    ArrayList<Integer>[] graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) graph[i] = new ArrayList<Integer>();
    int[] diff = new int[n + 1];
    Arrays.fill(diff, Integer.MIN_VALUE);
    int[] visited = new int[n + 1];
    for (int i = 1; i <= n - 1; i++) {
        int u = s.nextInt();
        int v = s.nextInt();
        graph[u].add(v);
        graph[v].add(u);
    }
    int[] ans = new int[n + 1];
    dfs(1, diff, visited, graph, a);
    Arrays.fill(visited, 0);
    dfs2(1, diff, visited, graph, a, ans, 0);
    for (int i = 1; i <= n; i++) System.out.print(ans[i] + " ");
}