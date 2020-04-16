static void solve() {
    n = in.nextInt();
    k = in.nextInt();
    g = new int[n][n];
    for (int v1 = 0; v1 < n; v1++) {
        for (int v2 = 0; v2 < n; v2++) {
            g[v1][v2] = in.nextInt();
        }
    }
    d = new ArrayList[n][n];
    for (int v1 = 0; v1 < n; v1++) {
        for (int v2 = 0; v2 < n; v2++) {
            d[v1][v2] = new ArrayList<>();
            for (int v3 = 0; v3 < n; v3++) {
                if (v3 == v1 || v3 == v2)
                    continue;
                d[v1][v2].add(new Pair(v3, g[v1][v3] + g[v3][v2]));
            }
            Collections.sort(d[v1][v2], ((o1, o2) -> Integer.compare(o1.d, o2.d)));
        }
    }
    used = new int[n];
    used[0]++;
    even = new int[k / 2 + 1];
    even[0] = even[k / 2] = 0;
    fun(1);
    out.println(ans);
}