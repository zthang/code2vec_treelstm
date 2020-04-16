static void solve() {
    FastReader fr = new FastReader();
    PrintWriter op = new PrintWriter(System.out);
    int n = fr.nextInt(), m = fr.nextInt(), k = fr.nextInt(), lvl[][] = new int[n][2], ds[][] = new int[k][2], ar[] = new int[k], i, j, l, ans;
    for (i = 0; i < k; ++i) ar[i] = fr.nextInt() - 1;
    ArrayList<ArrayList<Integer>> g = new ArrayList<>();
    for (i = 0; i < n; ++i) {
        g.add(new ArrayList<>());
        lvl[i][0] = lvl[i][1] = -1;
    }
    while (m-- > 0) {
        i = fr.nextInt() - 1;
        j = fr.nextInt() - 1;
        g.get(i).add(j);
        g.get(j).add(i);
    }
    Queue<Integer> q = new LinkedList<>();
    q.add(0);
    lvl[0][0] = 0;
    while (!q.isEmpty()) {
        i = q.poll();
        for (j = 0; j < g.get(i).size(); ++j) {
            l = g.get(i).get(j);
            if (lvl[l][0] != -1)
                continue;
            lvl[l][0] = lvl[i][0] + 1;
            q.add(l);
        }
    }
    ans = lvl[n - 1][0];
    q.add(n - 1);
    lvl[n - 1][1] = 0;
    while (!q.isEmpty()) {
        i = q.poll();
        for (j = 0; j < g.get(i).size(); ++j) {
            l = g.get(i).get(j);
            if (lvl[l][1] != -1)
                continue;
            lvl[l][1] = lvl[i][1] + 1;
            q.add(l);
        }
    }
    for (i = 0; i < k; ++i) {
        ds[i][0] = lvl[ar[i]][0];
        ds[i][1] = lvl[ar[i]][1];
    }
    sort(ds, 0, k - 1);
    l = 0;
    for (i = 0; i + 1 < k; ++i) {
        j = ds[i][0] + 1 + ds[i + 1][1];
        l = Math.max(l, j);
    }
    op.println(Math.min(ans, l));
    op.flush();
    op.close();
}