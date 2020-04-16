public void solve(int testNumber, FastScanner in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    long[] sum = new long[n];
    for (int i = 0; i < m; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        int c = in.nextInt();
        sum[a] -= c;
        sum[b] += c;
    }
    Integer[] all = new Integer[n];
    for (int i = 0; i < n; i++) {
        all[i] = i;
    }
    Arrays.sort(all, (u, v) -> Long.compare(sum[u], sum[v]));
    int i = 0;
    int j = n - 1;
    List<String> ans = new ArrayList<>();
    while (true) {
        while (i < n && sum[all[i]] >= 0) {
            ++i;
        }
        while (j >= 0 && sum[all[j]] <= 0) {
            --j;
        }
        if (i >= n || j < 0) {
            break;
        }
        long d = Math.min(Math.abs(sum[all[i]]), Math.abs(sum[all[j]]));
        ans.add(String.format("%d %d %d", all[i] + 1, all[j] + 1, d));
        sum[all[i]] += d;
        sum[all[j]] -= d;
    }
    out.println(ans.size());
    for (String s : ans) {
        out.println(s);
    }
}