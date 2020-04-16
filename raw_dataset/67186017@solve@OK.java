private static void solve(int q, FastScanner in, PrintWriter out) {
    for (int qq = 0; qq < q; qq++) {
        int n = in.nextInt(), m = in.nextInt();
        int[][] bl = new int[m][2];
        long[] debt = new long[m];
        for (int i = 0; i < m; i++) {
            bl[i][0] = in.nextInt();
            bl[i][1] = in.nextInt();
            debt[i] = in.nextLong();
        }
        long[] balance = new long[n + 1];
        for (int i = 0; i < m; i++) {
            balance[bl[i][0]] += debt[i];
            balance[bl[i][1]] -= debt[i];
        }
        List<long[]> pos = new ArrayList<>(), neg = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (balance[i] > 0) {
                pos.add(new long[] { i, balance[i] });
            } else if (balance[i] < 0) {
                neg.add(new long[] { i, balance[i] });
            }
        }
        List<long[]> ans = new ArrayList<>();
        int posIdx = 0, negIdx = 0;
        while (posIdx < pos.size()) {
            long[] pb = pos.get(posIdx);
            long[] nb = neg.get(negIdx);
            long amount = Math.min(Math.abs(pb[1]), Math.abs(nb[1]));
            ans.add(new long[] { pb[0], nb[0], amount });
            pb[1] -= amount;
            nb[1] += amount;
            if (pb[1] == 0) {
                posIdx++;
            }
            if (nb[1] == 0) {
                negIdx++;
            }
        }
        out.println(ans.size());
        for (int i = 0; i < ans.size(); i++) {
            long[] db = ans.get(i);
            out.println(db[0] + " " + db[1] + " " + db[2]);
        }
    }
    out.close();
}