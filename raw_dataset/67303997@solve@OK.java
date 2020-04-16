static void solve() {
    n = in.nextInt();
    l = new int[n];
    r = new int[n];
    a = new int[N];
    b = new int[N];
    for (int i = 0; i < n; i++) {
        l[i] = in.nextInt();
        r[i] = in.nextInt();
        a[l[i]] = r[i];
        b[l[i]] = b[r[i]] = i;
    }
    SegmentTree st = new SegmentTree();
    st.build();
    dsu = new DSU(n);
    cnt = 0;
    for (int i = 0; i < n; i++) {
        st.query(l[i], r[i], r[i]);
        if (cnt >= n)
            break;
    }
    if (cnt != n - 1 || dsu.size() != n) {
        out.println("NO");
        return;
    }
    out.println("YES");
}