void solve(InputReader in, PrintWriter w) {
    int t = in.nextInt();
    while (t-- > 0) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = i + 1;
        }
        if (m < n)
            w.println(-1);
        else if (m == n && n == 2)
            w.println(-1);
        else {
            m -= n;
            int res = 0;
            for (int i = 0; i < n; i++) {
                res += (2 * a[i][0]);
            }
            Arrays.sort(a, (o1, o2) -> o1[0] - o2[0]);
            for (int i = 0; i < m; i++) {
                res += (a[0][0] + a[1][0]);
            }
            w.println(res);
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    w.println((i + 1) + " 1");
                } else {
                    w.println((i + 1) + " " + (i + 2));
                }
            }
            while (m-- > 0) {
                w.println(a[0][1] + " " + a[1][1]);
            }
        }
    }
}