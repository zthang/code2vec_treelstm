public void solve(int testNumber, FastScanner in, PrintWriter out) {
    n = in.nextInt();
    int[][] a = new int[n][];
    neededSum = 0;
    sums = new long[n];
    for (int i = 0; i < n; i++) {
        int k = in.nextInt();
        a[i] = new int[k];
        for (int j = 0; j < k; j++) {
            a[i][j] = in.nextInt();
            neededSum += a[i][j];
            sums[i] += a[i][j];
        }
    }
    if (neededSum % n != 0) {
        out.println("No");
        return;
    }
    neededSum /= n;
    where = new HashMap<>();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < a[i].length; j++) {
            where.put((long) a[i][j], i);
        }
    }
    bitCount = new int[1 << n];
    for (int i = 0; i < bitCount.length; i++) {
        bitCount[i] = Integer.bitCount(i);
    }
    Entry[][] cycleSol = new Entry[1 << n][];
    List<Entry> sol = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        for (int x : a[i]) {
            search(i, i, x, x, 0, 0, sol, cycleSol);
        }
    }
    boolean[] can = new boolean[1 << n];
    int[] via = new int[1 << n];
    can[0] = true;
    for (int mask = 0; mask < 1 << n; mask++) {
        for (int submask = mask; submask > 0; submask = (submask - 1) & mask) {
            if (cycleSol[submask] != null && can[mask ^ submask]) {
                can[mask] = true;
                via[mask] = submask;
            }
        }
    }
    if (!can[(1 << n) - 1]) {
        out.println("No");
        return;
    }
    int[][] ans = new int[n][2];
    for (int mask = (1 << n) - 1; mask > 0; ) {
        int sm = via[mask];
        mask ^= sm;
        for (Entry e : cycleSol[sm]) {
            ans[e.from][0] = e.what;
            ans[e.from][1] = e.to + 1;
        }
    }
    out.println("Yes");
    for (int i = 0; i < n; i++) {
        out.println(ans[i][0] + " " + ans[i][1]);
    }
}