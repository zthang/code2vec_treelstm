public void solve(int testNumber, Input in, PrintWriter out) {
    try {
        int n = in.readInt();
        int k = in.readInt();
        int ans = 0;
        HashSet<Long> set = new HashSet<>();
        HashMap<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int a = in.readInt();
            int b = in.readInt();
            long pair = pair(a, b);
            if (set.contains(pair)) {
                ans++;
            } else {
                set.add(pair);
                g.computeIfAbsent(a, x -> new ArrayList<>()).add(b);
                g.computeIfAbsent(b, x -> new ArrayList<>()).add(a);
            }
        }
        boolean[] b = new boolean[n + 1];
        int[] q = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            if (b[i]) {
                continue;
            }
            q[0] = i;
            b[i] = true;
            int R = 1;
            for (int j = 0; j < R; j++) {
                for (int e : g.getOrDefault(q[j], Collections.emptyList())) {
                    // int s = second(e);
                    if (!b[e]) {
                        q[R] = e;
                        b[e] = true;
                        R++;
                    }
                // if (!b[s]) {
                // q[R] = s;
                // R++;
                // }
                }
            }
            long vertices = R;
            long edges = 0;
            for (int j = 0; j < R; j++) {
                long size = g.getOrDefault(q[j], Collections.emptyList()).size();
                edges += size;
            }
            edges /= 2;
            ans += Math.max(edges - vertices + 1, 0);
        }
        out.println(ans);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}