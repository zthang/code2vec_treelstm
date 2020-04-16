public void solve(int testNumber, Scanner in, PrintWriter out) {
    int N = in.nextInt();
    int K = in.nextInt();
    int[] p = new int[N];
    for (int i = 0; i < N; ++i) p[i] = i;
    int res = K;
    for (int i = 0; i < K; ++i) {
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