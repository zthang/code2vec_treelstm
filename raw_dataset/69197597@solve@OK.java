public void solve(int testNumber, InputReader c, OutputWriter w) {
    int n = c.readInt();
    ArrayList<Integer>[] adj = new ArrayList[n];
    int[] a = new int[n];
    tt = new int[n];
    for (int i = 0; i < n; i++) {
        adj[i] = new ArrayList<>();
    }
    int root = -1;
    for (int i = 0; i < n; i++) {
        int u = c.readInt() - 1;
        a[i] = c.readInt();
        if (u == -1) {
            root = i;
        } else {
            adj[u].add(i);
        }
    }
    TreeSet<iip> ts = new TreeSet<>();
    LinkedList<iip> q = new LinkedList<>();
    q.add(new iip(0, root));
    while (!q.isEmpty()) {
        iip pp = q.pollFirst();
        ts.add(pp);
        for (int x : adj[pp.b]) {
            q.add(new iip(pp.a + 1, x));
        }
    }
    // w.printLine(ts);
    // Arrays.fill(tt,-1);
    boolean isp = true;
    while (!ts.isEmpty()) {
        iip pp = ts.pollLast();
        ss = new ArrayList<>();
        solve_(pp.b, adj);
        Collections.sort(ss);
        if (ss.size() < a[pp.b] + 1) {
            isp = false;
            break;
        }
        for (int i = a[pp.b] + 1; i < ss.size(); i++) {
            tt[ss.get(i).b] += 2;
        }
        tt[pp.b] = ss.get(a[pp.b]).a + 1;
    }
    if (isp) {
        w.printLine("YES");
        w.printLine(tt);
    } else {
        w.printLine("NO");
    }
}