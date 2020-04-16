public void solve() {
    InputReader in = new InputReader(System.in);
    PrintWriter pw = new PrintWriter(System.out);
    int n = in.nextInt();
    int m = in.nextInt();
    for (int i = 0; i <= n; i++) {
        a[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < m; i++) {
        int x = in.nextInt();
        int y = in.nextInt();
        a[x].add(y);
        a[y].add(x);
    }
    dfs(1);
    long[] cnt = new long[4];
    for (int i = 1; i <= n; i++) {
        cnt[can[i]]++;
        if (can[i] == 0) {
            pw.print(-1);
            pw.flush();
            pw.close();
            return;
        }
    }
    long have = cnt[1] * cnt[2] + cnt[2] * cnt[3] + cnt[3] * cnt[1];
    if (have == m && cnt[2] > 0 && cnt[3] > 0) {
        for (int i = 1; i <= n; i++) {
            pw.print(can[i] + " ");
        }
    } else
        pw.print(-1);
    pw.flush();
    pw.close();
}