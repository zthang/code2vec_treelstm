public void solve(int testNumber, InputReader in, PrintWriter out) {
    int T = in.nextInt();
    while (T-- > 0) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = in.readIntArray(1, n);
        if (m < n || n == 2) {
            out.println(-1);
        } else {
            int mn = 100000;
            Pair[] pairs = new Pair[n];
            for (int i = 1; i <= n; ++i) {
                pairs[i - 1] = new Pair(a[i], i);
            }
            Arrays.sort(pairs, new Comparator<Pair>() {

                public int compare(Pair o1, Pair o2) {
                    if (o1.c != o2.c)
                        return o1.c - o2.c;
                    else {
                        return o1.id - o2.id;
                    }
                }
            });
            int sum = 0;
            for (int i = 1; i <= n; ++i) {
                sum += a[i] * 2;
            }
            sum += (pairs[0].c + pairs[1].c) * (m - n);
            out.println(sum);
            for (int i = 0; i < n - 1; ++i) {
                out.println((i + 1) + " " + (i + 2));
            }
            out.println(n + " " + (1));
            for (int i = 0; i < m - n; ++i) {
                out.println(pairs[0].id + " " + pairs[1].id);
            }
        }
    }
}