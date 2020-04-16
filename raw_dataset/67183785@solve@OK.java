public void solve(int testNumber, InputReader in, PrintWriter out) {
    int T = in.nextInt();
    for (int iter = 0; iter < T; iter++) {
        int K = in.nextInt();
        N = 2 * K;
        tree = new Node[2 * K];
        for (int i = 0; i < 2 * K; i++) {
            tree[i] = new Node();
        }
        for (int i = 0; i < 2 * K - 1; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int w = in.nextInt();
            tree[a].ch.add(new long[] { b, w });
            tree[b].ch.add(new long[] { a, w });
        }
        min = 0;
        max = 0;
        root(0, 0, 0);
        out.println(min + " " + max);
    }
}