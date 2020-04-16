static void solve() {
    int n = in.nextInt();
    int m = in.nextInt();
    HashSet<Edge> g = new HashSet<>();
    for (int i = 0; i < m; i++) {
        int v = in.nextInt() - 1;
        int u = in.nextInt() - 1;
        g.add(new Edge(v, u));
    }
    TreeSet<Integer> s = new TreeSet<>();
    for (int i = 0; i < n; i++) s.add(i);
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        if (!s.contains(i))
            continue;
        cnt++;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(i);
        s.remove(i);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (Iterator<Integer> it = s.iterator(); it.hasNext(); ) {
                int u = it.next();
                if (!g.contains(new Edge(v, u))) {
                    q.add(u);
                    it.remove();
                }
            }
        }
    }
    out.println(cnt - 1);
}