public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] p = new int[n];
    for (int i = 0; i < n; ++i) p[i] = i;
    int res = k;
    for (int i = 0; i < k; ++i) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        a = get(p, a);
        b = get(p, b);
        if (a != b) {
            --res;
            p[a] = b;
        }
    }
    out.println(res);
}