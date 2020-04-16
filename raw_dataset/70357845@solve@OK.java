public void solve(int testNumber, FastReader s, PrintWriter w) {
    int n = s.nextInt(), k = s.nextInt();
    int BL_SZ = k + 1 >> 1;
    boolean[] rep = new boolean[n];
    for (int i = 0; i < n; i++) if (query(i, s, w))
        rep[i] = true;
    for (int i = 0; i < n; i += BL_SZ) {
        for (int j = i + BL_SZ; j < n; j += BL_SZ) {
            reset(w);
            for (int l = i, c = 0; c < BL_SZ; l++, c++) query(l, s, w);
            for (int l = j, c = 0; c < BL_SZ; l++, c++) if (query(l, s, w))
                rep[l] = true;
        }
    }
    int ans = 0;
    for (int i = 0; i < n; i++) if (!rep[i])
        ans++;
    w.println("! " + ans);
    w.flush();
}