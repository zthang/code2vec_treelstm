private static void solve(int q, FastScanner in, PrintWriter out) {
    for (int qq = 0; qq < q; qq++) {
        int n = in.nextInt();
        Map<Integer, TreeSet<Integer>> dk = new HashMap<>();
        Map<Integer, Set<Integer>> kd = new HashMap<>();
        for (int i = 0; i < n; i++) {
            dk.put(i, new TreeSet<>());
            int m = in.nextInt();
            for (int j = 0; j < m; j++) {
                int kk = in.nextInt() - 1;
                dk.get(i).add(kk);
                kd.putIfAbsent(kk, new HashSet<>());
                kd.get(kk).add(i);
            }
        }
        boolean[] dPicked = new boolean[n], kPicked = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (dk.get(i).size() > 0) {
                int pick = dk.get(i).pollFirst();
                dPicked[i] = true;
                kPicked[pick] = true;
                if (kd.get(pick) != null) {
                    for (int d : kd.get(pick)) {
                        dk.get(d).remove(pick);
                    }
                }
            }
        }
        int idx1 = 0;
        for (; idx1 < n; idx1++) {
            if (!dPicked[idx1]) {
                break;
            }
        }
        if (idx1 == n) {
            out.println("OPTIMAL");
        } else {
            int idx2 = 0;
            for (; idx2 < n; idx2++) {
                if (!kPicked[idx2]) {
                    break;
                }
            }
            out.println("IMPROVE");
            out.println((idx1 + 1) + " " + (idx2 + 1));
        }
    }
    out.close();
}