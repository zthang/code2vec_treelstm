public void solve(int testNumber, FastReader s, PrintWriter w) {
    int n = s.nextInt(), m = s.nextInt();
    ArrayList<Integer>[] a = new ArrayList[n];
    ArrayList<pair<Integer, Integer>> e = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        a[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
        int x = s.nextInt() - 1, y = s.nextInt() - 1;
        a[x].add(y);
        e.add(new pair(x, y));
    }
    boolean[] vis = new boolean[n], st = new boolean[n];
    boolean b = false;
    for (int i = 0; i < n; i++) {
        vis[i] = true;
        b |= dfs(vis, st, i, a);
    }
    if (b) {
        w.println(2);
        for (int i = 0; i < m; i++) w.print((e.get(i).x < e.get(i).y ? 1 : 2) + " ");
    } else {
        w.println(1);
        for (int i = 0; i < m; i++) w.print(1 + " ");
    }
}