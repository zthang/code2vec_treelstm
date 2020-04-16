public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    ArrayList[] a = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) a[i] = new ArrayList();
    int count = n;
    for (int i = 0; i < m; i++) {
        int u = in.nextInt();
        int v = in.nextInt();
        a[u].add(v);
        a[v].add(u);
    }
    for (int i = 1; i <= n; i++) {
        if (a[i].size() == 0) {
            count--;
        }
    }
    if (count <= 6) {
        out.println(m);
        return;
    }
    int min = Integer.MAX_VALUE;
    int an = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = i + 1; j <= n; j++) {
            if (true) {
                if (true) {
                    int temp = 0;
                    for (int k = 0; k < a[i].size(); k++) {
                        if (a[j].contains(a[i].get(k))) {
                            temp++;
                        }
                    }
                    // temp--;
                    // out.println(temp);
                    // out.println(m-temp);
                    an = Math.max(an, m - temp);
                }
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        min = Math.min(min, a[i].size());
    }
    if (m - min + 1 <= 16) {
        out.println(Math.max(m - min + 1, an));
    } else {
        out.println(16);
    }
}