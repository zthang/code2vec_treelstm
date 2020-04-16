private void solve(InputReader in, PrintWriter out) {
    int n = in.nextInt(), m = in.nextInt();
    int[] a = in.readIntArray(n);
    if (n <= 2 || m < n) {
        out.println(-1);
        return;
    }
    Util.ASSERT(n == m);
    int cost = 0;
    for (int x : a) {
        cost += 2 * x;
    }
    out.println(cost);
    for (int i = 0; i < n; i++) {
        out.println(Util.join(i + 1, (i + 1) % n + 1));
    }
}