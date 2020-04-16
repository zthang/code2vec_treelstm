public void run() {
    try {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        n = in.ni();
        vis = new int[n + 1][n + 1];
        ans = new char[n + 1][n + 1];
        a = new pair[n + 1][n + 1];
        HashMap<pair, Integer> hm = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int x = in.ni();
                int y = in.ni();
                pair p = new pair(x, y);
                int kk = 0;
                if (hm.containsKey(p))
                    kk = hm.get(p);
                hm.put(p, kk + 1);
                a[i][j] = new pair(x, y);
            }
        }
        int kk = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i][j].f == i && a[i][j].s == j) {
                    ans[i][j] = 'X';
                    k = 0;
                    dfs(i, j, i, j);
                    pair p = new pair(i, j);
                    if (k != hm.get(p)) {
                        kk = 1;
                        break;
                    }
                }
            }
        }
        // System.out.println("hiii");
        if (kk == 1) {
            out.println("INVALID");
        } else {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (vis[i][j] == 0 && a[i][j].f != -1 && a[i][j].s != -1) {
                        kk = 1;
                        break;
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (vis[i][j] == 0) {
                        boolean b = ddffss(i, j);
                        if (!b) {
                            kk = 1;
                            break;
                        }
                    }
                }
            }
            if (kk == 1)
                out.println("INVALID");
            else {
                out.println("VALID");
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) out.print(ans[i][j]);
                    out.println();
                }
            }
        }
        out.close();
    } catch (Exception e) {
        System.out.println(e);
    }
}