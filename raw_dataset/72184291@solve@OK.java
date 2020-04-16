public void solve(int testNumber, FastReader s, PrintWriter w) {
    int n = s.nextInt(), m = s.nextInt();
    ArrayList<Integer>[] a = new ArrayList[n], t = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        a[i] = new ArrayList<>();
        t[i] = new ArrayList<>();
    }
    while (m-- > 0) {
        int u = s.nextInt() - 1, v = s.nextInt() - 1;
        t[v].add(u);
        a[u].add(v);
    }
    int k = s.nextInt();
    int[] dis = new int[n], p = new int[k];
    Arrays.fill(dis, (int) 1e7);
    for (int i = 0; i < k; i++) p[i] = s.nextInt() - 1;
    LinkedList<pair<Integer, Integer>> l = new LinkedList<>();
    l.add(new pair<>(p[k - 1], 0));
    boolean[] vis = new boolean[n];
    vis[p[k - 1]] = true;
    while (!l.isEmpty()) {
        pair<Integer, Integer> cur = l.poll();
        dis[cur.x] = cur.y;
        for (int i : t[cur.x]) {
            if (!vis[i]) {
                vis[i] = true;
                l.add(new pair<>(i, cur.y + 1));
            }
        }
    }
    int mn = 0, mx = 0;
    for (int i = 0; i < k - 1; i++) {
        boolean ok = false;
        int tot = 0;
        for (int j : a[p[i]]) {
            if (dis[j] == dis[p[i]] - 1) {
                tot++;
                if (j == p[i + 1])
                    ok = true;
            }
        }
        if (!ok) {
            mn++;
            mx++;
        } else if (tot > 1)
            mx++;
    }
    w.println(mn + " " + mx);
}