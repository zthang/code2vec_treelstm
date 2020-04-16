public void solve(int testNumber, FastReader s, PrintWriter w) {
    // Solution credit:  mango_lassi
    n = s.nextInt();
    int root = 0;
    a = new ArrayList[n];
    c = new int[n];
    ans = new int[n];
    for (int i = 0; i < n; i++) a[i] = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        int x = s.nextInt();
        c[i] = s.nextInt();
        if (x == 0)
            root = i;
        else
            a[x - 1].add(i);
    }
    if (dfs(root)) {
        w.println("YES");
        for (int i = 0; i < n; i++) w.print(ans[i] + " ");
    } else
        w.println("NO");
}