void solve() {
    int n = ni(), m = ni();
    HashSet<Integer>[] hs = new HashSet[n + 1];
    for (int i = 1; i <= n; i++) hs[i] = new HashSet<>();
    int[] deg = new int[n + 1];
    Arrays.fill(deg, n - 1);
    while (m-- > 0) {
        int x = ni(), y = ni();
        deg[x]--;
        deg[y]--;
        hs[x].add(y);
        hs[y].add(x);
    }
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
        if (2 * deg[i] > n)
            list.add(i);
    }
    F = new int[n + 1];
    sz = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        F[i] = i;
        sz[i] = 1;
    }
    for (int i = 1; i < list.size(); i++) {
        union(list.get(i - 1), list.get(i));
    }
    for (int i = 1; i <= n; i++) {
        if (2 * deg[i] > n)
            continue;
        for (int j = 1; j <= n; j++) if (!hs[i].contains(j))
            union(i, j);
    }
    int ans = 0;
    for (int i = 1; i <= n; i++) if (root(i) == i)
        ans++;
    ans--;
    pw.println(ans);
}