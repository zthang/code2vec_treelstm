static void solve() throws Exception {
    int n = scanInt(), m = scanInt();
    IntList[] higherBad = new IntList[n];
    for (int i = 0; i < n; i++) {
        higherBad[i] = new IntList();
    }
    int[] nBad = new int[n];
    for (int i = 0; i < m; i++) {
        int a = scanInt() - 1, b = scanInt() - 1;
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        higherBad[a].push(b);
        ++nBad[a];
        ++nBad[b];
    }
    long ans = 0, pans[] = new long[n];
    for (int i = 0; i < n; i++) {
        ans += pans[i] = (long) (nBad[i] - higherBad[i].size()) * higherBad[i].size();
    }
    out.println(ans);
    int q = scanInt();
    for (int qq = 0; qq < q; qq++) {
        int cur = scanInt() - 1;
        ans -= pans[cur];
        pans[cur] = 0;
        for (int i = 0; i < higherBad[cur].size; i++) {
            int e = higherBad[cur].data[i];
            higherBad[e].push(cur);
            ans -= pans[e];
            ans += pans[e] = (long) (nBad[e] - higherBad[e].size()) * higherBad[e].size();
        }
        higherBad[cur].clear();
        out.println(ans);
    }
}