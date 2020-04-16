public void run() {
    FastScanner fs = new FastScanner();
    PrintWriter out = new PrintWriter(System.out);
    System.err.println("");
    int T = fs.nextInt();
    while (T-- > 0) {
        int n = fs.nextInt(), ptr = 0;
        int[][] adj = readTree(n, fs);
        int[] order = new int[n], par = new int[n];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(0);
        Arrays.fill(par, -1);
        par[0] = 0;
        while (!dq.isEmpty()) {
            int u = dq.pollFirst();
            order[ptr++] = u;
            for (int v : adj[u]) {
                if (par[u] == v)
                    continue;
                par[v] = u;
                dq.add(v);
            }
        }
        int res = 0;
        int[] dp = new int[n];
        int[] mx = new int[2];
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            mx[0] = -1;
            mx[1] = -1;
            int kids = 0;
            for (int v : adj[u]) if (v != par[u]) {
                updateMax(mx, dp[v]);
                kids++;
            }
            int sum = 0, used = 0;
            if (mx[0] != -1) {
                sum += mx[0];
                used++;
            }
            if (mx[1] != -1) {
                sum += mx[1];
                used++;
            }
            res = Math.max(res, 1 + sum + (kids - used) + (par[u] != u ? 1 : 0));
            dp[u] = 1 + kids - (used > 0 ? 1 : 0);
            if (mx[0] != -1)
                dp[u] += mx[0];
        }
        out.println(res);
    }
    out.close();
}