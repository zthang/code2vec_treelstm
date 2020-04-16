void solve() {
    int n = ni();
    pt = new int[n];
    for (int i = 0; i < n; i++) pt[i] = i;
    pair[] a = new pair[n];
    HashMap<Integer, Integer> mp = new HashMap<>();
    for (int i = 0; i < n; i++) {
        a[i] = new pair(ni(), ni());
        int j = (int) (i * Math.random());
        pair p = a[i];
        a[i] = a[j];
        a[j] = p;
    }
    Arrays.sort(a, (pair u, pair v) -> (u.L - v.L));
    TreeSet<Integer> r = new TreeSet<>();
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        mp.put(a[i].R, i);
        Integer k = r.higher(a[i].L);
        while (k != null && k < a[i].R) {
            int j = mp.get(k);
            if (!union(i, j)) {
                out.println("NO");
                return;
            }
            cnt++;
            k = r.higher(k);
        }
        r.add(a[i].R);
    }
    // out.println(cnt);
    out.println((cnt == n - 1) ? "YES" : "NO");
}