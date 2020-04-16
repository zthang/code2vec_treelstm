void solve() {
    int n = in.nextInt();
    int m = in.nextInt();
    long[] balance = new long[n];
    for (int i = 0; i < m; i++) {
        int fr = in.nextInt() - 1;
        int to = in.nextInt() - 1;
        int cost = in.nextInt();
        balance[fr] -= cost;
        balance[to] += cost;
    }
    int itPlus = 0, itMinus = 0;
    List<long[]> ans = new ArrayList<>();
    while (true) {
        while (itPlus != balance.length && balance[itPlus] <= 0) {
            itPlus++;
        }
        while (itMinus != balance.length && balance[itMinus] >= 0) {
            itMinus++;
        }
        if (itPlus == balance.length) {
            if (itMinus != balance.length) {
                throw new AssertionError();
            }
            break;
        }
        long mx = Math.min(balance[itPlus], -balance[itMinus]);
        ans.add(new long[] { itMinus + 1, itPlus + 1, mx });
        balance[itPlus] -= mx;
        balance[itMinus] += mx;
    }
    out.println(ans.size());
    for (long[] t : ans) {
        out.println(t[0] + " " + t[1] + " " + t[2]);
    }
}