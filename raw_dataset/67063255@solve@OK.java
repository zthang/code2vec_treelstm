void solve() {
    StringBuffer sb = new StringBuffer();
    int T = ni();
    while (T-- > 0) {
        int N = ni();
        int M = ni();
        int A = ni();
        int B = ni();
        p = new int[N + 1];
        nextTo = new int[N + 1];
        size = new int[N + 1];
        Arrays.fill(size, 1);
        int[][] edges = na(M, 2);
        for (int[] e : edges) {
            if (e[0] == A)
                nextTo[e[1]] |= 1;
            else if (e[0] == B)
                nextTo[e[1]] |= 2;
            if (e[1] == A)
                nextTo[e[0]] |= 1;
            else if (e[1] == B)
                nextTo[e[0]] |= 2;
        }
        for (int[] e : edges) {
            if (e[0] == A || e[0] == B || e[1] == A || e[1] == B)
                continue;
            connect(e[0], e[1]);
        }
        long[] cnt = new long[4];
        for (int i = 1; i <= N; i++) {
            if (p[i] == 0 && i != A && i != B)
                cnt[nextTo[i]] += size[i];
        }
        sb.append(cnt[1] * cnt[2]).append(System.lineSeparator());
    }
    out.print(sb);
}