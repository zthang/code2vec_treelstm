public void run() {
    try {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.ni();
        while (t-- != 0) {
            int n = in.ni();
            ArrayList<Integer>[] g = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                int k = in.ni();
                for (int j = 1; j <= k; j++) g[i].add(in.ni());
                Collections.sort(g[i]);
            }
            int[] vis = new int[n + 1];
            HashSet<Integer> hs = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                for (int j : g[i]) {
                    if (vis[j] == 0) {
                        vis[j] = 1;
                        hs.add(i);
                        break;
                    }
                }
            }
            if (hs.size() == n)
                out.println("OPTIMAL");
            else {
                out.println("IMPROVE");
                int ans1 = 0, ans2 = 0;
                for (int i = 1; i <= n; i++) {
                    if (!hs.contains(i)) {
                        ans1 = i;
                        for (int j = 1; j <= n; j++) {
                            if (vis[j] == 0) {
                                ans2 = j;
                                break;
                            }
                        }
                        break;
                    }
                }
                out.println(ans1 + " " + ans2);
            }
        }
        out.close();
    } catch (Exception e) {
        System.out.println(e);
    }
}