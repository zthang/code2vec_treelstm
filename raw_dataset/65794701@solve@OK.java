private static void solve(int q, FastScanner in, PrintWriter out) {
    for (int qq = 0; qq < q; qq++) {
        int n = in.nextInt();
        int[][] city = new int[n][2];
        long[] psc = new long[n];
        long[] cc = new long[n];
        for (int i = 0; i < n; i++) {
            city[i][0] = in.nextInt();
            city[i][1] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            psc[i] = in.nextLong();
        }
        for (int i = 0; i < n; i++) {
            cc[i] = in.nextLong();
        }
        long minCost = 0;
        PriorityQueue<long[]> minPq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        List<Long> ps = new ArrayList<>();
        List<long[]> edges = new ArrayList<>();
        int includeCnt = 0;
        boolean[] included = new boolean[n];
        for (int i = 0; i < n; i++) {
            minPq.add(new long[] { psc[i], -1, i });
        }
        while (includeCnt < n) {
            long[] curr = minPq.poll();
            if (included[(int) curr[2]]) {
                continue;
            }
            if (curr[1] == -1) {
                ps.add(curr[2]);
            } else {
                edges.add(new long[] { curr[1], curr[2] });
            }
            minCost += curr[0];
            includeCnt++;
            included[(int) curr[2]] = true;
            // update keys that might have changed
            for (int i = 0; i < n; i++) {
                if (included[i]) {
                    continue;
                }
                long newKey = (Math.abs(city[(int) curr[2]][0] - city[i][0]) + Math.abs(city[(int) curr[2]][1] - city[i][1])) * (cc[(int) curr[2]] + cc[i]);
                minPq.add(new long[] { newKey, curr[2], i });
            }
        }
        out.println(minCost);
        out.println(ps.size());
        for (int i = 0; i < ps.size(); i++) {
            out.print((ps.get(i) + 1) + " ");
        }
        out.println();
        out.println(edges.size());
        for (int i = 0; i < edges.size(); i++) {
            out.println((edges.get(i)[0] + 1) + " " + (edges.get(i)[1] + 1));
        }
    }
    out.close();
}