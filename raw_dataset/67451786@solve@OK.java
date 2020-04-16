public void solve(int testNumber, InputReader c, OutputWriter w) {
    int n = c.readInt(), m = c.readInt();
    HashSet<Integer>[] adj = new HashSet[n];
    TreeSet<Integer> unvis = new TreeSet<>();
    for (int i = 0; i < n; i++) {
        adj[i] = new HashSet<>();
        unvis.add(i);
    }
    for (int i = 0; i < m; i++) {
        int u = c.readInt() - 1, v = c.readInt() - 1;
        adj[u].add(v);
        adj[v].add(u);
    }
    ArrayList<Integer> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        if (!unvis.contains(i)) {
            continue;
        }
        unvis.remove(i);
        LinkedList<Integer> q = new LinkedList<>();
        q.add(i);
        int cnt = 1;
        while (!q.isEmpty() && !unvis.isEmpty()) {
            int x = q.poll();
            ArrayList<Integer> rem = new ArrayList<>();
            for (int kl : unvis) {
                if (!adj[x].contains(kl)) {
                    q.add(kl);
                    cnt++;
                    rem.add(kl);
                }
            }
            for (int kl : rem) {
                unvis.remove(kl);
            }
        }
        res.add(cnt);
    }
    w.printLine(res.size() - 1);
}