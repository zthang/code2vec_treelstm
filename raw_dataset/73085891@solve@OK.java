public void solve() throws IOException {
    InputReader in = new InputReader(System.in);
    PrintWriter pw = new PrintWriter(System.out);
    int n = in.nextInt();
    for (int i = 1; i <= n; i++) {
        val[i] = in.nextInt();
        a[i] = new ArrayList<Integer>();
        if (val[i] == 0)
            val[i]--;
    }
    for (int i = 0; i < n - 1; i++) {
        int x = in.nextInt();
        int y = in.nextInt();
        a[x].add(y);
        a[y].add(x);
    }
    dfs(1, 0);
    ans[1] = dp[1];
    dfs1(1, 0);
    for (int i = 1; i <= n; i++) {
        pw.print(ans[i] + " ");
    }
    pw.flush();
    pw.close();
}