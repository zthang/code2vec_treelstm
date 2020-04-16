public void solve(int testNumber, InputReader in, OutputWriter out) {
    this.in = in;
    this.out = out;
    int t = in.nextInt();
    while (t-- > 0) {
        int n = in.nextInt();
        int m = in.nextInt();
        int sum = 0;
        PairII[] a = new PairII[n + 1];
        for (int i = 1; i <= n; i++) sum += in.nextInt();
        if (n != m || n == 2) {
            out.println(-1);
            continue;
        }
        out.println(sum * 2);
        for (int i = 1; i < n; i++) {
            out.println(i + " " + (i + 1));
        }
        out.println(n + " " + 1);
    }
}