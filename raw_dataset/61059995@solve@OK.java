static void solve() throws Exception {
    n = scanInt();
    m = scanInt();
    a = new int[m];
    b = new int[m];
    for (int i = 0; i < m; i++) {
        a[i] = scanInt() - 1;
        b[i] = scanInt() - 1;
    }
    color = new int[n];
    cnt = 0;
    have = new boolean[6][6];
    out.print(go(0));
}