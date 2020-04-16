public void solve(int testNumber, FastScanner in, PrintWriter out) {
    long startT = System.currentTimeMillis();
    final int infinity = (int) (1e9 + 100);
    int n = in.nextInt();
    int k = in.nextInt();
    int[][] a = new int[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            a[i][j] = in.nextInt();
        }
    }
    long prevT = System.currentTimeMillis();
    long maxT = 0;
    int ans = infinity;
    SplittableRandom random = new SplittableRandom();
    int[] col = new int[n];
    int[][] d = new int[k + 1][n];
    while (true) {
        long curT = System.currentTimeMillis();
        maxT = Math.max(maxT, curT - prevT);
        if (curT + 3 * maxT > startT + 2900) {
            break;
        }
        prevT = curT;
        for (int i = 0; i < n; i++) {
            col[i] = random.nextInt(2);
        }
        for (int[] arr : d) {
            Arrays.fill(arr, infinity);
        }
        d[0][0] = 0;
        for (int len = 0; len < k; len++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (col[i] == col[j]) {
                        continue;
                    }
                    d[len + 1][j] = Math.min(d[len + 1][j], d[len][i] + a[i][j]);
                }
            }
        }
        ans = Math.min(ans, d[k][0]);
    }
    out.println(ans);
}