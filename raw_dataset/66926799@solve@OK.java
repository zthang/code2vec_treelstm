public void solve(int testNumber, MyInput in, PrintWriter out) {
    Thread th = new Thread(null, () -> {
        int T = in.nextInt();
        while (T-- > 0) {
            n = in.nextInt();
            g = new List[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                g[i] = new ArrayList<>();
            }
            for (int i = 0; i < 2 * n - 1; i++) {
                int s = in.nextInt() - 1;
                int t = in.nextInt() - 1;
                int v = in.nextInt();
                g[s].add(new int[] { t, v });
                g[t].add(new int[] { s, v });
            }
            S ans = dfs(0, -1);
            out.println(Long.toUnsignedString(ans.best) + " " + Long.toUnsignedString(ans.worst));
        }
    }, "", 1 << 27);
    th.start();
    try {
        th.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}