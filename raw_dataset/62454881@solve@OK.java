static void solve() {
    FastReader fr = new FastReader();
    PrintWriter op = new PrintWriter(System.out);
    grph = new ArrayList<ArrayList<Integer>>();
    hs = new HashSet<Integer>();
    int n = fr.nextInt(), m = fr.nextInt(), ans = Integer.MIN_VALUE, ctr, i, j, k;
    for (i = 0; i < n; i++) grph.add(new ArrayList<Integer>());
    for (i = 0; i < m; ++i) {
        j = fr.nextInt() - 1;
        k = fr.nextInt() - 1;
        grph.get(j).add(k);
        grph.get(k).add(j);
    }
    dfs(0);
    if (hs.size() == 7) {
        for (i = 0; i < 7; ++i) {
            for (j = i + 1; j < 7; ++j) {
                hs.clear();
                ctr = 0;
                for (k = 0; k < grph.get(i).size(); ++k) hs.add(grph.get(i).get(k));
                for (k = 0; k < grph.get(j).size(); ++k) {
                    if (hs.contains(grph.get(j).get(k)))
                        ++ctr;
                }
                ans = Math.max(ans, m - ctr);
            }
        }
        op.println(ans);
    } else
        op.println(m);
    op.flush();
    op.close();
}