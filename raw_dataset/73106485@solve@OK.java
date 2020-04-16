public static void solve(Reader in, Writer out) {
    int n = in.nextInt();
    con = new ArrayList[n];
    dp = new int[n];
    ans = new int[n];
    col = in.na(n);
    for (int i = 0; i < n; i++) if (col[i] == 0)
        col[i]--;
    for (int i = 0; i < n; i++) con[i] = new ArrayList<Integer>();
    for (int i = 0; i < n - 1; i++) {
        int a = in.nextInt() - 1, b = in.nextInt() - 1;
        con[a].add(b);
        con[b].add(a);
    }
    dfs(0, -1);
    dfs2(0, -1);
    for (Integer i : ans) out.print(i + " ");
}