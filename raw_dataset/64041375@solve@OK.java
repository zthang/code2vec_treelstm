public void solve(int testNumber, inputClass sc, PrintWriter out) {
    int n = sc.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    for (int i = 0; i < n; i++) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
    }
    subsets = new DShichikujiAndPowerGrid.Subset[n + 1];
    for (int i = 0; i < n + 1; i++) {
        subsets[i] = new DShichikujiAndPowerGrid.Subset();
        subsets[i].parent = i;
        subsets[i].rank = 0;
    }
    int[] c = new int[n];
    for (int i = 0; i < n; i++) {
        c[i] = sc.nextInt();
    }
    int[] k = new int[n];
    for (int i = 0; i < n; i++) {
        k[i] = sc.nextInt();
    }
    int m = (n * (n - 1)) / 2;
    int nb = 0;
    DShichikujiAndPowerGrid.Edges[] edges = new DShichikujiAndPowerGrid.Edges[m + n];
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            long w = ((long) k[i] + k[j]) * ((long) Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]));
            edges[nb] = new DShichikujiAndPowerGrid.Edges();
            edges[nb].u = i;
            edges[nb].v = j;
            edges[nb].w = w;
            nb++;
        }
    }
    for (int i = 0; i < n; i++) {
        edges[nb] = new DShichikujiAndPowerGrid.Edges();
        edges[nb].u = n;
        edges[nb].v = i;
        edges[nb].w = c[i];
        nb++;
    }
    ArrayList<DShichikujiAndPowerGrid.Edges> resultat = new ArrayList<>();
    Arrays.sort(edges, Comparator.comparingLong(a -> a.w));
    for (DShichikujiAndPowerGrid.Edges a : edges) {
        if (find(a.u) != find(a.v)) {
            union(a.u, a.v);
            resultat.add(a);
        }
    }
    ArrayList<Integer> bestcent = new ArrayList<>();
    ArrayList<DShichikujiAndPowerGrid.Pair> bestcon = new ArrayList<>();
    long ans = 0;
    for (DShichikujiAndPowerGrid.Edges a : resultat) {
        if (a.u == n) {
            bestcent.add(a.v);
        } else {
            bestcon.add(new DShichikujiAndPowerGrid.Pair(a.u, a.v));
        }
        ans += a.w;
    }
    out.println(ans);
    out.println(bestcent.size());
    for (int i : bestcent) {
        out.print((i + 1) + " ");
    }
    out.println();
    out.println(bestcon.size());
    for (DShichikujiAndPowerGrid.Pair p : bestcon) {
        out.println((p.u + 1) + " " + (p.w + 1));
    }
}