private static void solve() throws IOException {
    int n = sc.nextInt(), m = sc.nextInt();
    dsu dsu = new dsu(n + 1);
    PriorityQueue<pp> pps = new PriorityQueue<>(new Comparator<pp>() {

        @Override
        public int compare(pp o1, pp o2) {
            if (o1.wheight > o2.wheight)
                return 1;
            else if (o1.wheight < o2.wheight)
                return -1;
            else
                return 0;
        }
    });
    for (int i = 1; i <= n - 1; ++i) {
        int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
        pps.add(new pp(u, v, w));
    }
    int maxSize = (int) 2e5 + 3;
    long[] dp = new long[maxSize];
    while (!pps.isEmpty()) {
        pp p = pps.poll();
        dp[p.wheight] += (1L * dsu.rank[dsu.dad(p.head)] * dsu.rank[dsu.dad(p.tail)]);
        dsu.merge(dsu.dad(p.head), dsu.dad(p.tail));
    }
    for (int i = 1; i < maxSize; ++i) dp[i] += dp[i - 1];
    while (m-- > 0) pr.print(dp[sc.nextInt()] + " ");
}