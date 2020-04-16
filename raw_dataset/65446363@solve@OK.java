public void solve(int testNumber, InputReader sc, PrintWriter out) {
    int n = sc.nextInt();
    int m = sc.nextInt();
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += sc.nextInt();
    }
    if (m <= 2 || n != m) {
        out.println(-1);
        return;
    }
    out.println(2 * sum);
    for (int i = 1; i < m; i++) {
        out.println(i + " " + (i + 1));
    }
    out.println("1 " + n);
}