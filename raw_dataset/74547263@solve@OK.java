static void solve() {
    FastReader fr = new FastReader();
    PrintWriter op = new PrintWriter(System.out);
    int n = fr.nextInt(), m = fr.nextInt(), a[], i, j, k, l;
    boolean f;
    lvl = new int[n + 1];
    p = new int[n + 1];
    rng = new int[n + 1][2];
    g = new ArrayList<>();
    for (i = 0; i <= n; ++i) {
        g.add(new ArrayList<>());
        p[i] = -1;
        lvl[i] = -1;
    }
    for (i = 0; i + 1 < n; ++i) {
        j = fr.nextInt();
        k = fr.nextInt();
        g.get(j).add(k);
        g.get(k).add(j);
    }
    rng[0][0] = 0;
    rng[0][1] = dfs(1, 0, 1);
    while (m-- > 0) {
        k = fr.nextInt();
        a = new int[k];
        for (i = 0; i < k; ++i) a[i] = fr.nextInt();
        sort(a, 0, k - 1);
        i = p[a[0]];
        l = lvl[a[0]];
        for (j = 1; j < k; ++j) {
            if (l == lvl[a[j]]) {
                if (!chk(i, a[j]))
                    break;
            } else {
                if (chk(i, a[j])) {
                    i = p[a[j]];
                    l = lvl[a[j]];
                } else
                    break;
            }
        }
        if (j == k)
            op.println("YES");
        else
            op.println("NO");
    }
    op.flush();
    op.close();
}