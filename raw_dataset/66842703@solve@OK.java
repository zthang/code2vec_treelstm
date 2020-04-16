public void solve(int testNumber, InputReader s, PrintWriter w) {
    int t = s.nextInt();
    while (t-- > 0) {
        int n = s.nextInt(), m = s.nextInt(), a = s.nextInt() - 1, b = s.nextInt() - 1;
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = s.nextInt() - 1, v = s.nextInt() - 1;
            adj[u].add(v);
            adj[v].add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        int[] an = new int[n];
        an[a] = 1;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : adj[x]) {
                if (an[y] == 0 && y != b) {
                    q.add(y);
                    an[y] = 1;
                }
            }
        }
        q.clear();
        q.add(b);
        int[] bn = new int[n];
        bn[b] = 1;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : adj[x]) {
                if (bn[y] == 0 && y != a) {
                    q.add(y);
                    bn[y] = 1;
                }
            }
        }
        long ac = -1, bc = -1;
        for (int i = 0; i < n; i++) {
            if (an[i] == 1 && bn[i] == 0)
                ac++;
            if (an[i] == 0 && bn[i] == 1)
                bc++;
        }
        w.println(ac * bc);
    }
}