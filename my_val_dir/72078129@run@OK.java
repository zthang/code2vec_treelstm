public void run() {
    try {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.ni();
        int m = in.ni();
        int k = in.ni();
        int[] a = new int[n + 1];
        for (int i = 1; i <= k; i++) {
            int x = in.ni();
            a[x] = 1;
        }
        ArrayList<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            int u = in.ni();
            int v = in.ni();
            g[u].add(v);
            g[v].add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] dist1 = new int[n + 1];
        int[] dist2 = new int[n + 1];
        q.add(1);
        int[] vis = new int[n + 1];
        vis[1] = 1;
        while (!q.isEmpty()) {
            int u = q.remove();
            for (int v : g[u]) {
                if (vis[v] == 0) {
                    vis[v] = 1;
                    q.add(v);
                    dist1[v] = dist1[u] + 1;
                }
            }
        }
        Arrays.fill(vis, 0);
        q.add(n);
        vis[n] = 1;
        while (!q.isEmpty()) {
            int u = q.remove();
            for (int v : g[u]) {
                if (vis[v] == 0) {
                    vis[v] = 1;
                    q.add(v);
                    dist2[v] = dist2[u] + 1;
                }
            }
        }
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (a[i] == 1) {
                pq.add(new pair(i, dist1[i] - dist2[i]));
            }
        }
        int max = -1000000000, best = 0;
        while (!pq.isEmpty()) {
            pair p = pq.remove();
            // out.println("    "+p.f+" "+p.s);
            best = Math.max(best, max + dist2[p.f]);
            max = Math.max(max, dist1[p.f]);
        // out.println(best+" "+max);
        }
        out.println(Math.min(dist1[n], best + 1));
        out.close();
    } catch (Exception e) {
        System.out.println(e);
    }
}