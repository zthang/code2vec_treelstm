public void run() {
    FastScanner fs = new FastScanner();
    PrintWriter out = new PrintWriter(System.out);
    System.err.println("");
    int n = fs.nextInt();
    int m = fs.nextInt();
    ArrayList<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
    for (int i = 0; i < m; i++) {
        int u = fs.nextInt() - 1;
        int v = fs.nextInt() - 1;
        adj[u].add(v);
        adj[v].add(u);
    }
    for (int i = 0; i < n; i++) {
        adj[i].add(i);
        Collections.sort(adj[i]);
    }
    boolean[] used = new boolean[n];
    ArrayDeque<Integer> dq = new ArrayDeque<>();
    TreeSet<Integer> set = new TreeSet<>();
    for (int i = 0; i < n; i++) set.add(i);
    DSU ds = new DSU(n);
    for (int i = 0; i < n; i++) {
        if (used[i])
            continue;
        used[i] = true;
        dq.add(i);
        while (!dq.isEmpty()) {
            int u = dq.pollFirst();
            int last = -1;
            for (int v : adj[u]) {
                Integer to;
                while ((to = set.lower(v)) != null && to > last) {
                    set.remove(to);
                    ds.union(u, to);
                    if (!used[to]) {
                        used[to] = true;
                        dq.add(to);
                    }
                }
                last = v;
            }
            Integer to;
            while ((to = set.higher(last)) != null) {
                set.remove(to);
                ds.union(u, to);
                if (!used[to]) {
                    used[to] = true;
                    dq.add(to);
                }
            }
        }
    }
    int c = 0;
    for (int i = 0; i < n; i++) {
        if (ds.par[i] == i)
            c++;
    }
    out.println(c - 1);
    out.close();
}