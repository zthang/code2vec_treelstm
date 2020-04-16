void solve() {
    int n = ni();
    int[][] a = new int[n][];
    Map<Long, Long> ci = new HashMap<>();
    long[] sums = new long[n];
    for (int i = 0; i < n; i++) {
        int K = ni();
        a[i] = na(K);
        for (int j = 0; j < K; j++) {
            ci.put((long) a[i][j], (long) i << 32 | j);
            sums[i] += a[i][j];
        }
    }
    long S = 0;
    for (long v : sums) {
        S += v;
    }
    if (S % n != 0) {
        out.println("No");
        return;
    }
    S /= n;
    int[] offsets = new int[n + 1];
    for (int i = 0; i < n; i++) {
        offsets[i + 1] = offsets[i] + a[i].length;
    }
    int m = offsets[n];
    int[] f = new int[m];
    Arrays.fill(f, -1);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < a[i].length; j++) {
            long T = a[i][j] + S - sums[i];
            if (ci.containsKey(T)) {
                long code = ci.get(T);
                int from = offsets[i] + j;
                int to = offsets[(int) (code >>> 32)] + (int) code;
                if (from != to && i == (int) (code >>> 32))
                    continue;
                f[from] = to;
            }
        }
    }
    int[][] cs = getCycles(f);
    int[][] zcs = new int[1 << n][];
    for (int[] c : cs) {
        int ptn = 0;
        for (int k : c) {
            int ind = Arrays.binarySearch(offsets, k);
            if (ind < 0)
                ind = -ind - 2;
            ptn |= 1 << ind;
        }
        if (Integer.bitCount(ptn) != c.length)
            continue;
        zcs[ptn] = c;
    }
    boolean[] dp = new boolean[1 << n];
    dp[0] = true;
    for (int i = 1; i < 1 << n; i++) {
        if (zcs[i] != null) {
            int mask = (1 << n) - 1 ^ i;
            for (int j = mask; j >= 0; j--) {
                j &= mask;
                dp[i | j] |= dp[j];
            }
        // include j=0
        }
    }
    if (dp[(1 << n) - 1]) {
        int[] vals = new int[n];
        int[] tos = new int[n];
        int cur = (1 << n) - 1;
        inner: while (cur > 0) {
            for (int k = cur; k >= 0; k--) {
                k &= cur;
                if (dp[cur ^ k] && zcs[k] != null) {
                    for (int l = 0; l < zcs[k].length; l++) {
                        int nl = (l + zcs[k].length - 1) % zcs[k].length;
                        int fclus = Arrays.binarySearch(offsets, zcs[k][l]);
                        int tclus = Arrays.binarySearch(offsets, zcs[k][nl]);
                        if (fclus < 0)
                            fclus = -fclus - 2;
                        if (tclus < 0)
                            tclus = -tclus - 2;
                        int val = a[fclus][zcs[k][l] - offsets[fclus]];
                        vals[fclus] = val;
                        tos[fclus] = tclus;
                    }
                    cur ^= k;
                    continue inner;
                }
            }
        }
        out.println("Yes");
        for (int i = 0; i < n; i++) {
            out.println(vals[i] + " " + (tos[i] + 1));
        }
    // for(int i = 0;i < n;i++){
    // sums[i] -= vals[i];
    // sums[tos[i]] += vals[i];
    // }
    // 
    // for(int i = 0;i < n;i++){
    // assert sums[i] == S;
    // }
    } else {
        out.println("No");
    }
}