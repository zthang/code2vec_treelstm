public void run() {
    try {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.ni();
        int m = in.ni();
        g = new ArrayList[n + 1];
        g1 = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
            g1[i] = new ArrayList<>();
        }
        for (int i = 1; i <= m; i++) {
            int u = in.ni();
            int v = in.ni();
            g[v].add(u);
            g1[u].add(v);
        }
        int k = in.ni();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 1; i <= k; i++) al.add(in.ni());
        int[] dist = new int[n + 1];
        int[] vis = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(al.get(k - 1));
        vis[al.get(k - 1)] = 1;
        while (!q.isEmpty()) {
            int u = q.remove();
            for (int v : g[u]) {
                if (vis[v] == 0) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                    vis[v] = 1;
                }
            }
        }
        // for(int i=1;i<=n;i++)
        // out.println(i+" "+dist[i]);
        int min = 0, max = 0;
        for (int i = 1; i < al.size(); i++) {
            int curr = al.get(i);
            int prev = al.get(i - 1);
            if (dist[prev] != dist[curr] + 1) {
                min++;
                max++;
            } else {
                int y = 0;
                for (int j : g1[prev]) {
                    if (dist[j] + 1 == dist[prev])
                        y++;
                }
                if (y > 1)
                    max++;
            }
        // out.println(curr+" "+min+" "+max);
        }
        out.println(min + " " + max);
        out.close();
    } catch (Exception e) {
        System.out.println(e);
    }
}