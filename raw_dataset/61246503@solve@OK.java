public void solve(int testNumber, Scanner in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    Set<Integer> verts = new HashSet<>();
    List<Integer>[] adj = new List[n + 1];
    for (int i = 0; i < n + 1; i++) {
        adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
        int a = in.nextInt();
        int b = in.nextInt();
        adj[a].add(b);
        adj[b].add(a);
        verts.add(a);
        verts.add(b);
    }
    if (verts.size() <= 6) {
        out.println(m);
        return;
    }
    int max = 0;
    for (int i = 1; i < n + 1; i++) {
        for (int j = i + 1; j < n + 1; j++) {
            int sub = 0;
            boolean contains = adj[i].contains(j);
            sub += adj[i].size();
            sub += adj[j].size();
            if (contains) {
                sub--;
            }
            int doms = m - sub;
            Set<Integer> hs = new HashSet<>();
            hs.addAll(adj[i]);
            hs.addAll(adj[j]);
            doms += hs.size();
            if (contains) {
                doms--;
            }
            max = Math.max(doms, max);
        }
    }
    out.println(max);
}