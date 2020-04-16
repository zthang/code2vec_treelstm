void solve() {
    int t = ni();
    while (t-- > 0) {
        int n = ni();
        a = new int[n + 1];
        int ans = n;
        for (int i = 1; i <= n; i++) {
            a[i] = ni();
            if (i == a[i]) {
                ans = 1;
            }
        }
        c = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            c[i] = ni();
        }
        vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                List<Integer> circle = new ArrayList<>();
                int x = i;
                while (!vis[x]) {
                    circle.add(x);
                    vis[x] = true;
                    x = a[x];
                }
                debug(circle);
                ans = Math.min(ans, circle.size());
                for (int skip = 1; skip < circle.size() && skip < ans; skip++) {
                    if (circle.size() % skip == 0) {
                        for (int j = 0; j < skip; j++) {
                            int next = (j + skip) % circle.size();
                            boolean ok = true;
                            while (next != j && ok) {
                                debug(circle.get(next));
                                if (c[circle.get(j)] != c[circle.get(next)]) {
                                    ok = false;
                                }
                                next = (next + skip) % circle.size();
                            }
                            if (ok) {
                                ans = Math.min(ans, skip);
                                break;
                            }
                        }
                    }
                }
            }
        }
        out.println(ans);
    }
}