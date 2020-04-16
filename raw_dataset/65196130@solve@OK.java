public Object solve() {
    int N = sc.nextInt(), M = sc.nextInt();
    int[][] E = dec(sc.nextInts(M));
    DSU dsu = new DSU(N);
    for (int[] e : E) dsu.add(e[0], e[1]);
    int[] C = dsu.cc();
    int S = 0, res = 0;
    while (S < N) {
        int T = C[S];
        for (int i = S; i <= T; ++i) T = max(T, C[i]);
        for (int i = S; i <= T; ++i) if (dsu.add(S, i))
            ++res;
        S = T + 1;
    }
    return res;
}