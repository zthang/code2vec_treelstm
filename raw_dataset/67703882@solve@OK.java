public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
        sum += 2 * a[i];
    }
    if (m < n || n == 2) {
        out.println(-1);
        return;
    }
    out.println(sum);
    for (int i = 0; i < m - 1; i++) {
        out.println((i + 1) + " " + (i + 2));
    }
    out.println(1 + " " + n);
}