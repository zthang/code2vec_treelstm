public Object solve() {
    int N = sc.nextInt(), M = sc.nextInt();
    int[][] E = dec(sc.nextInts(M));
    int[][] G = graph(N, E);
    int[] V = new int[N];
    fill(V, 1);
    for (int j : G[0]) V[j] = 0;
    if (G[0].length == 0)
        return -1;
    int v2 = G[0][0];
    boolean[] D2 = new boolean[N];
    fill(D2, true);
    for (int j : G[v2]) D2[j] = false;
    for (int i : rep(N)) if (D2[i]) {
        if (V[i] != 0)
            return -1;
        V[i] = 2;
    }
    int v3 = -1;
    for (int i : rep(N)) if (V[i] == 0)
        v3 = i;
    if (v3 == -1)
        return -1;
    boolean[] D3 = new boolean[N];
    fill(D3, true);
    for (int j : G[v3]) D3[j] = false;
    for (int i : rep(N)) if (D3[i]) {
        if (V[i] != 0)
            return -1;
        V[i] = 3;
    }
    long[] C = new long[4];
    for (int i : rep(N)) ++C[V[i]];
    if (C[0] > 0)
        return -1;
    long P = C[1] * C[2] + C[2] * C[3] + C[3] * C[1];
    if (P != M)
        return -1;
    for (int[] e : E) if (V[e[0]] == V[e[1]])
        return -1;
    return V;
}