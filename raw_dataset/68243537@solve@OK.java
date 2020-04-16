public void solve(PrintWriter pw) {
    FastReader sc = new FastReader();
    int n = sc.nextInt(), k = sc.nextInt();
    ArrayList<Integer>[] adj = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
    Pair<Integer, Integer>[] a = new Pair[k + 1];
    for (int i = 1; i <= k; i++) {
        int x = sc.nextInt(), y = sc.nextInt();
        a[i] = new Pair(x, y);
        adj[x].add(i);
        adj[y].add(i);
    }
    HashSet<Integer> hs = new HashSet();
    HashSet<Integer> list = new HashSet();
    HashSet<Integer> person = new HashSet();
    int s = 0;
    for (int i = 1; i <= n; i++) {
        s += ls(i, adj, a, hs, list, person);
    }
    pw.println(s);
}