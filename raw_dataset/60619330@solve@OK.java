void solve() throws IOException {
    FastReader sc = new FastReader();
    int n = sc.nextInt();
    int m = sc.nextInt();
    a = new ArrayList[n + 1];
    for (int i = 0; i < n; i++) a[i] = new ArrayList<>();
    u = new boolean[n + 1];
    for (int i = 0; i < m; i++) {
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        a[x].add(y);
        a[y].add(x);
    }
    int c = 0;
    for (int i = 0; i < n; i++) {
        if (!u[i]) {
            dfs(i);
            c++;
        }
    }
    System.out.println(m - n + c);
}