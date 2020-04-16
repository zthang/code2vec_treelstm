static void solve() {
    int n = in.nextInt();
    int m = in.nextInt();
    dd = new long[n][2];
    for (int i = 0; i < n; i++) {
        dd[i][0] = i;
    }
    for (int i = 0; i < m; i++) {
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        long d = in.nextLong();
        dd[a][1] -= d;
        dd[b][1] += d;
    }
    Arrays.sort(dd, (o1, o2) -> Long.compare(o1[1], o2[1]));
    g = new ArrayList<>();
    int l = 0, r = n - 1;
    while (l < r) {
        if (-dd[l][1] > dd[r][1]) {
            g.add(new D(dd[l][0], dd[r][0], dd[r][1]));
            dd[l][1] += dd[r][1];
            dd[r][1] = 0;
            r--;
        } else if (-dd[l][1] < dd[r][1]) {
            g.add(new D(dd[l][0], dd[r][0], -dd[l][1]));
            dd[r][1] -= -dd[l][1];
            dd[l][1] = 0;
            l++;
        } else {
            if (dd[l][1] != 0)
                g.add(new D(dd[l][0], dd[r][0], -dd[l][1]));
            dd[l][1] = 0;
            dd[r][1] = 0;
            l++;
            r--;
        }
    }
    out.println(g.size());
    for (D d : g) {
        out.println((d.a + 1) + " " + (d.b + 1) + " " + (d.d));
    }
}