public final void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] min = new int[n + 1];
    int[] max = new int[n + 1];
    int[] par = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        par[i] = min[i] = max[i] = i;
    }
    int ccSize = n;
    for (int[] e : in.nextIntMatrix(m, 2)) {
        ccSize -= join(par, min, max, e[0], e[1]);
    }
    boolean[] used = new boolean[n + 1];
    int[][] cc = new int[ccSize][];
    for (int i = 1, pt = 0; i <= n; i++) {
        int ri = find(par, i);
        if (used[ri]) {
            continue;
        }
        used[ri] = true;
        cc[pt++] = new int[] { min[ri], max[ri], ri };
    }
    Arrays.sort(cc, Comparators.pairIntArr);
    int ans = 0;
    for (int i = 0; i < ccSize; i++) {
        int ri = cc[i][2];
        int j = i;
        while (++j < ccSize) {
            int rj = cc[j][2];
            if (min[rj] > max[ri]) {
                break;
            }
            max[ri] = Math.max(max[ri], max[rj]);
            ++ans;
        }
        i = j - 1;
    }
    out.println(ans);
}