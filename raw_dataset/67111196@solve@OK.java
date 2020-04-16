void solve() throws IOException {
    n = in.nextInt();
    m = in.nextInt();
    tot = new long[n];
    component = new int[n];
    vis = new boolean[n];
    adj = new List[n];
    edges = new Edge[m];
    asc = new HashMap<>();
    desc = new HashMap<>();
    for (int i = 0; i < n; i++) {
        adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
        int u = in.nextInt() - 1;
        int v = in.nextInt() - 1;
        long d = in.nextLong();
        adj[u].add(v);
        adj[v].add(u);
        edges[i] = new Edge(u, v, d);
        tot[u] -= d;
        tot[v] += d;
    }
    int counter = 0;
    Comparator<Integer> ascendingComp = (o1, o2) -> {
        if (tot[o1] == tot[o2]) {
            return Integer.compare(o1, o2);
        }
        return Long.compare(tot[o1], tot[o2]);
    };
    Comparator<Integer> descendingComp = (o1, o2) -> {
        if (tot[o1] == tot[o2]) {
            return Integer.compare(o2, o1);
        }
        return Long.compare(tot[o2], tot[o1]);
    };
    for (int i = 0; i < n; i++) {
        if (!vis[i]) {
            counter++;
            TreeSet<Integer> aset = new TreeSet<>(ascendingComp);
            TreeSet<Integer> dset = new TreeSet<>(descendingComp);
            asc.put(counter, aset);
            desc.put(counter, dset);
            vis[i] = true;
            dfs(i, counter, aset, dset);
        }
    }
    ans = new ArrayList<>();
    for (Map.Entry<Integer, TreeSet<Integer>> entry : asc.entrySet()) {
        find(entry.getKey());
    }
    out.println(ans.size());
    for (Edge edge : ans) {
        out.println(edge.from + 1 + " " + (edge.to + 1) + " " + edge.debt);
    }
}