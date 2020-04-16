static void solve() throws Exception {
    int n = nextInt(), m = nextInt();
    long[] bal = new long[n];
    for (int i = 0; i < m; i++) {
        int u = nextInt() - 1, v = nextInt() - 1, d = nextInt();
        bal[u] += d;
        bal[v] -= d;
    }
    int[] ansU = new int[n], ansV = new int[n];
    long[] ansD = new long[n];
    int ansCnt = 0;
    for (int p1 = 0, p2 = 0; ; ) {
        while (p1 < n && bal[p1] <= 0) {
            ++p1;
        }
        while (p2 < n && bal[p2] >= 0) {
            ++p2;
        }
        if (p1 == n || p2 == n) {
            break;
        }
        ansU[ansCnt] = p1;
        ansV[ansCnt] = p2;
        long d = ansD[ansCnt] = min(bal[p1], -bal[p2]);
        bal[p1] -= d;
        bal[p2] += d;
        ++ansCnt;
    }
    out.println(ansCnt);
    for (int i = 0; i < ansCnt; i++) {
        out.println((ansU[i] + 1) + " " + (ansV[i] + 1) + " " + ansD[i]);
    }
}