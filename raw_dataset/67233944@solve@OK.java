public Object solve() {
    int N = sc.nextInt(), M = 2 * N;
    int[][] S = sc.nextInts(N);
    int[][] V = new int[M][];
    for (int i : rep(N)) {
        V[2 * i] = new int[] { i, S[i][0], 1 };
        V[2 * i + 1] = new int[] { i, S[i][1], -1 };
    }
    sort(V, by(1));
    DSU dsu = new DSU(N);
    Queue<int[]> Q = stack(), R = stack();
    for (int[] v : V) {
        int i = v[0];
        if (v[2] == 1)
            Q.add(v);
        else {
            int x = S[i][0];
            while (Q.peek()[1] > x) {
                int[] w = Q.poll();
                int j = w[0];
                if (!dsu.add(i, j))
                    return "NO";
                R.add(w);
            }
            Q.poll();
            while (!R.isEmpty()) Q.add(R.poll());
        }
    }
    int[] C = dsu.cc();
    for (int i : rep(1, N)) if (C[i] != C[i - 1])
        return "NO";
    return "YES";
}