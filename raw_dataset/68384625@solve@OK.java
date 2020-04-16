void solve() {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    int n = in.nextInt(), root = 0;
    g = new ArrayList[n + 1];
    h = new ArrayList[n + 1];
    c = new int[3000];
    for (int i = 1; i <= n; i++) {
        g[i] = new ArrayList<Integer>();
        h[i] = new ArrayList<Integer>();
    }
    for (int i = 1; i <= n; i++) {
        int p = in.nextInt();
        c[i] = in.nextInt();
        if (p > 0)
            g[p].add(i);
        else
            root = i;
    }
    dfs(root, 0);
    int[] ans = new int[n + 1];
    if (ok > 0) {
        out.println("YES");
        int num = 0;
        for (int t : h[root]) ans[t] = ++num;
        for (int i = 1; i <= n; i++) out.print(ans[i] + " ");
    } else
        out.println("NO");
    out.close();
}