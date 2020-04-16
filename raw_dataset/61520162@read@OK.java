void read() throws IOException {
    in = new FastScanner(System.in);
    int t = 1;
    while (t-- > 0) {
        n = in.nextInt();
        m = in.nextInt();
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int from = in.nextInt() - 1;
            int to = in.nextInt() - 1;
            g[from].add(to);
            g[to].add(from);
        }
    }
}