public void solve() throws FileNotFoundException {
    InputReader in = new InputReader(System.in);
    PrintWriter pw = new PrintWriter(System.out);
    int t = in.nextInt();
    while (t-- > 0) {
        int n = in.nextInt();
        for (int i = 0; i <= 2 * n; i++) {
            a[i] = new ArrayList<pair>();
        }
        for (int i = 0; i < 2 * n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            long d = in.nextLong();
            a[u].add(new pair(v, d));
            a[v].add(new pair(u, d));
        }
        visited = new boolean[2 * n + 1];
        dfs(1, 2L * n);
        pw.println(mini + " " + maxi);
        mini = 0;
        maxi = 0;
    }
    pw.flush();
    pw.close();
}