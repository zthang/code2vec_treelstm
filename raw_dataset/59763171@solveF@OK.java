private void solveF() throws IOException {
    int n = in.nextInt(), k = in.nextInt();
    int[] p = new int[n], posP = new int[n];
    for (int i = 0; i < n; i++) posP[p[i] = in.nextInt() - 1] = i;
    int[] q = new int[n], posQ = new int[n];
    for (int i = 0; i < n; i++) posQ[q[i] = in.nextInt() - 1] = i;
    int[] prefP = new int[n];
    for (int i = 0; i < n; i++) prefP[i] = max(i == 0 ? -1 : prefP[i - 1], posQ[p[i]]);
    int[] prefQ = new int[n];
    for (int i = 0; i < n; i++) prefQ[i] = max(i == 0 ? -1 : prefQ[i - 1], posP[q[i]]);
    int[] ans = new int[n];
    fill(ans, -1);
    int cnt = 0;
    for (int pi = 0, qi = -1; pi < n; cnt++, pi++) {
        int ppi = pi, pqi = qi;
        while (true) {
            if (qi < prefP[pi])
                qi = prefP[pi];
            else
                break;
            if (pi < prefQ[qi])
                pi = prefQ[qi];
            else
                break;
        }
        while (ppi <= pi) if (ans[p[ppi++]] == -1)
            ans[p[ppi - 1]] = cnt;
        pqi++;
        while (pqi <= qi) if (ans[q[pqi++]] == -1)
            ans[q[pqi - 1]] = cnt;
    }
    if (cnt >= k) {
        out.println("YES");
        for (int i = 0; i < n; i++) out.print((char) ('a' + min(k - 1, ans[i])));
    } else
        out.println("NO");
}