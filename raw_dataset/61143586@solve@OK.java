public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    edges = new int[m][2];
    for (int i = 0; i < m; i++) {
        edges[i][0] = in.nextInt() - 1;
        edges[i][1] = in.nextInt() - 1;
    }
    best = 0;
    used = new boolean[10];
    dots = new int[10];
    Arrays.fill(dots, -1);
    rec(0, n, 6);
    out.println(best);
}