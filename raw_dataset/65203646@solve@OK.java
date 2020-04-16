void solve() {
    n = in.nextInt();
    m = in.nextInt();
    nodes = new Node[n + 1];
    for (int i = 0; i <= n; i++) {
        nodes[i] = new Node();
    }
    for (int i = 0; i < m; i++) {
        int u = in.nextInt();
        int v = in.nextInt();
        nodes[u].n.add(v);
        nodes[v].n.add(u);
    }
    max = new int[n + 1];
    fillMax(max);
    int maxsf = 0;
    int ans = 0;
    Set<Integer> s = new HashSet<>();
    for (int i = 1; i <= n; i++) {
        maxsf = Math.max(max[i], maxsf);
        s.add(max[i]);
        if (i == maxsf) {
            ans += s.size() - 1;
            s = new HashSet<>();
        }
    }
    out.println(ans);
}