void run() throws IOException {
    int q = nextInt();
    while (q-- > 0) {
        comp_a = new TreeMap<>();
        comp_b = new TreeMap<>();
        int n = nextInt();
        int m = nextInt();
        for_a = new int[n];
        for_b = new int[n];
        a = nextInt() - 1;
        b = nextInt() - 1;
        graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int from = nextInt() - 1;
            int to = nextInt() - 1;
            graph[from].add(to);
            graph[to].add(from);
        }
        used = new boolean[n];
        int c = 1;
        for (int i = 0; i < used.length; i++) {
            if (!used[i] && i != a) {
                dfs_a(i, c);
                c++;
            }
        }
        used = new boolean[n];
        c = 1;
        for (int i = 0; i < used.length; i++) {
            if (!used[i] && i != b) {
                dfs_b(i, c);
                c++;
            }
        }
        long ans = (long) (n - 2) * (n - 3) / 2;
        TreeMap<point, Long> tm = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if (i == a || i == b)
                continue;
            point x = new point(for_a[i], for_b[i]);
            tm.put(x, tm.getOrDefault(x, 0L) + 1);
        }
        for (Integer x : comp_a.keySet()) ans -= comp_a.get(x) * (comp_a.get(x) - 1) / 2;
        for (Integer x : comp_b.keySet()) ans -= comp_b.get(x) * (comp_b.get(x) - 1) / 2;
        for (point x : tm.keySet()) ans += tm.get(x) * (tm.get(x) - 1) / 2;
        pw.println(ans);
    }
    pw.close();
}