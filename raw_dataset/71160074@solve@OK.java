public void solve() throws IOException {
    int t = readInt();
    for (int f = 0; f < t; f++) {
        int n = readInt();
        String s = readString();
        int[] dp = new int[n + 1];
        dp[n - 1] = 1;
        for (int i = n - 2; i >= 1; i--) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                dp[i] = dp[i + 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        int[] min = new int[n + 1];
        int[] max = new int[n + 1];
        int[] seg = new int[4 * n + 4];
        int[] segma = new int[4 * n + 4];
        build(seg, 1, n, 0);
        build(segma, 1, n, 0);
        for (int i = 1; i <= n; i++) {
            int val = dp[i];
            int len = n - i + 1;
            if (i != n && s.charAt(i - 1) == '<') {
                int z = find(seg, 1, n, 0, len - dp[i]);
                del(seg, 1, n, 0, z);
                out.print(z + " ");
            } else {
                int z = find(seg, 1, n, 0, len);
                del(seg, 1, n, 0, z);
                out.print(z + " ");
            }
        }
        out.println();
        for (int i = 1; i <= n; i++) {
            int val = dp[i];
            int len = n - i + 1;
            if (i != n && s.charAt(i - 1) == '>') {
                int z = find(segma, 1, n, 0, 1 + dp[i]);
                del(segma, 1, n, 0, z);
                out.print(z + " ");
            } else {
                int z = find(segma, 1, n, 0, 1);
                del(segma, 1, n, 0, z);
                out.print(z + " ");
            }
        }
        out.println();
    }
}