static void solve() {
    FastReader fr = new FastReader();
    PrintWriter op = new PrintWriter(System.out);
    int n = fr.nextInt(), m = fr.nextInt(), o, p[], lvl[] = new int[n], i, j, k, l, min, max;
    ArrayList<ArrayList<Integer>> g = new ArrayList<>(), h = new ArrayList<>();
    for (i = 0; i < n; ++i) {
        g.add(new ArrayList<>());
        h.add(new ArrayList<>());
        lvl[i] = -1;
    }
    while (m-- > 0) {
        i = fr.nextInt() - 1;
        j = fr.nextInt() - 1;
        g.get(j).add(i);
        h.get(i).add(j);
    }
    o = fr.nextInt();
    p = new int[o];
    for (i = 0; i < o; ++i) p[i] = fr.nextInt() - 1;
    Queue<Integer> q = new LinkedList<>();
    q.add(p[o - 1]);
    lvl[p[o - 1]] = min = max = 0;
    while (!q.isEmpty()) {
        i = q.poll();
        for (j = 0; j < g.get(i).size(); ++j) {
            k = g.get(i).get(j);
            if (lvl[k] != -1)
                continue;
            lvl[k] = lvl[i] + 1;
            q.add(k);
        }
    }
    for (i = 0; i + 1 < o; ++i) {
        if (lvl[p[i]] - 1 < lvl[p[i + 1]]) {
            ++min;
            ++max;
        } else if (lvl[p[i]] - 1 == lvl[p[i + 1]]) {
            j = 0;
            for (k = 0; k < h.get(p[i]).size(); ++k) {
                l = h.get(p[i]).get(k);
                if (lvl[p[i]] - 1 == lvl[l])
                    ++j;
            }
            if (j > 1)
                ++max;
        } else
            System.out.println("err");
    }
    op.println(min + " " + max);
    op.flush();
    op.close();
}