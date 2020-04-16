static void solve() {
    FastReader fr = new FastReader();
    PrintWriter op = new PrintWriter(System.out);
    int n = fr.nextInt(), i, j, k, l, deg[] = new int[n], dum[] = new int[3];
    grph = new ArrayList<ArrayList<Integer>>();
    cst = new long[3][n];
    long ans, sm;
    int[] clr = new int[3], dum_ = new int[3];
    for (i = 0; i < 3; ++i) {
        for (j = 0; j < n; ++j) {
            cst[i][j] = fr.nextInt();
            if (i == 0)
                grph.add(new ArrayList<Integer>());
        }
    }
    for (i = 1; i < n; ++i) {
        j = fr.nextInt() - 1;
        k = fr.nextInt() - 1;
        grph.get(j).add(k);
        grph.get(k).add(j);
        deg[j]++;
        deg[k]++;
    }
    j = 0;
    k = -1;
    ans = Long.MAX_VALUE;
    for (i = 0; i < n; ++i) {
        if (j < deg[i]) {
            j = deg[i];
            k = i;
        }
    }
    if (j < 3) {
        for (i = 0; i < 3; ++i) {
            dum[0] = dum_[0] = i;
            for (j = 0; j < 3; ++j) {
                if (i == j)
                    continue;
                dum[1] = j;
                dum[2] = 3 - dum[0] - dum[1];
                sm = cst[dum[0]][k];
                dum_[1] = dum[2];
                dum_[2] = dum[1];
                sm += find(grph.get(k).get(0), k, dum, 1);
                sm += find(grph.get(k).get(1), k, dum_, 1);
                if (sm < ans) {
                    ans = sm;
                    for (l = 0; l < 3; ++l) clr[l] = dum[l];
                }
            }
        }
        op.println(ans);
        sqnc = new int[n];
        sqnc[k] = clr[0];
        paint(grph.get(k).get(0), k, clr, 1);
        swap(clr);
        paint(grph.get(k).get(1), k, clr, 1);
        for (i = 0; i < n; i++) op.print((sqnc[i] + 1) + " ");
    } else
        op.println("-1");
    op.flush();
    op.close();
}