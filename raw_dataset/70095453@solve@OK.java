static void solve() {
    FastReader fr = new FastReader();
    PrintWriter op = new PrintWriter(System.out);
    ArrayList<ArrayList<Integer>> g = new ArrayList<>(), g_ = new ArrayList<>(), mp = new ArrayList<>();
    int t = fr.nextInt(), n, m, a, b, i, j, k;
    long dm, rpt;
    while (t-- > 0) {
        n = fr.nextInt();
        m = fr.nextInt();
        p = new int[n][2];
        dm = rpt = 0l;
        a = fr.nextInt() - 1;
        b = fr.nextInt() - 1;
        ctr = new long[n];
        for (i = 0; i < n; ++i) {
            g.add(new ArrayList<>());
            g_.add(new ArrayList<>());
            p[i][0] = p[i][1] = -1;
            mp.add(new ArrayList<>());
        }
        while (m-- > 0) {
            i = fr.nextInt() - 1;
            j = fr.nextInt() - 1;
            if (i != a && j != a) {
                g.get(i).add(j);
                g.get(j).add(i);
            }
            if (i != b && j != b) {
                g_.get(i).add(j);
                g_.get(j).add(i);
            }
        }
        j = -1;
        for (i = 0; i < n; ++i) {
            if (p[i][0] == -1)
                dfs(g, i, 0, ++j);
        }
        for (i = 0; i <= j; ++i) {
            if (p[b][0] != i)
                dm += nC2(ctr[i]);
            else
                dm += nC2(ctr[i] - 1);
        }
        j = -1;
        for (i = 0; i < n; ++i) {
            if (p[i][1] == -1) {
                ctr[++j] = 0;
                dfs(g_, i, 1, j);
            }
        }
        for (i = 0; i <= j; ++i) {
            if (p[a][1] != i)
                dm += nC2(ctr[i]);
            else
                dm += nC2(ctr[i] - 1);
        }
        for (i = 0; i < n; ++i) {
            if (i != a && i != b)
                mp.get(p[i][0]).add(p[i][1]);
        }
        for (i = 0; i < n; ++i) {
            Collections.sort(mp.get(i));
            j = 0;
            while (j < mp.get(i).size() - 1) {
                k = j + 1;
                while (k < mp.get(i).size() && mp.get(i).get(j) == mp.get(i).get(k)) ++k;
                rpt += nC2(k - j);
                j = k;
            }
        }
        dm -= rpt;
        rpt = nC2(n - 2l);
        dm = rpt - dm;
        op.println(dm);
        g.clear();
        g_.clear();
        mp.clear();
    }
    op.flush();
    op.close();
}