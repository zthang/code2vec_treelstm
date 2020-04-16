public void solve() throws Exception {
    FastScanner scanner = new FastScanner();
    PrintWriter out = new PrintWriter(System.out, false);
    int t = scanner.nextInt();
    top: while (t-- > 0) {
        int n = scanner.nextInt();
        int[] to = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int next = i - scanner.nextInt();
            to[i] = next;
        }
        boolean[] vis = new boolean[n + 1];
        StringBuilder stringBuilder = new StringBuilder();
        int cyclestart = -1;
        int cur = to[1];
        while (true) {
            vis[cur] = true;
            cur = to[cur];
            if (vis[cur]) {
                cyclestart = cur;
                break;
            }
        }
        int cnt = 0;
        vis = new boolean[n + 1];
        cur = cyclestart;
        while (true) {
            vis[cur] = true;
            stringBuilder.append(cur + " ");
            cnt++;
            cur = to[cur];
            if (vis[cur]) {
                break;
            }
        }
        out.println(cnt);
        out.println(stringBuilder.toString());
    }
    out.flush();
}