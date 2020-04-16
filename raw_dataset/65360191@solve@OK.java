void solve(FastReader s, PrintWriter w) {
    int n = s.nextInt(), m = s.nextInt();
    int[][] a = new int[n][2];
    int sum = 0;
    for (int i = 0; i < n; i++) {
        a[i][0] = s.nextInt();
        sum += a[i][0];
        a[i][1] = i + 1;
    }
    if (m < n || n == 2) {
        w.println(-1);
        return;
    }
    func.sortbyColumn(a, 0);
    int ans = sum << 1;
    for (int i = n; i < m; i++) ans += a[0][0] + a[1][0];
    w.println(ans);
    for (int i = 0; i < n; i++) w.println((i + 1) + " " + ((i + 1) % n + 1));
    for (int i = n; i < m; i++) w.println(a[0][1] + " " + a[1][1]);
}