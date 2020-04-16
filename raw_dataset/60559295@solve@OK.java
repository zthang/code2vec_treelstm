public void solve(int testNumber, InputReader sc, PrintWriter out) throws IOException {
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] d = new int[n + 1];
    int[] pre = new int[n + 1];
    for (int i = 1; i <= n; i++) pre[i] = i;
    for (int i = 0; i < k; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        join(u, v, pre);
    }
    int ans = k;
    int[] cnt = new int[n + 1];
    for (int i = 1; i <= n; i++) cnt[find(i, pre)]++;
    for (int i = 1; i <= n; i++) {
        if (cnt[i] != 0) {
            ans -= (cnt[i] - 1);
        }
    }
    out.println(ans);
}