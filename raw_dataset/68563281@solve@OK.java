Object solve(int N, int[][] A) {
    int H = compress(A);
    SumNode S = new SumNode(2 * H);
    for (int[] a : A) {
        for (int i : rep(2)) a[i] *= 2;
        S.add(1, a[0], a[1] + 1);
    }
    dfs(S, 0);
    List<Integer> M = new ArrayList<>();
    int res = 1;
    for (int i : rep(1, L.size() - 1)) {
        int[] a = L.get(i - 1), b = L.get(i), c = L.get(i + 1);
        if (b[2] == 0)
            ++res;
        if (a[2] > 1 && b[2] == 1 && c[2] > 1)
            M.add(b[1]);
    }
    int Y = 0;
    for (int[] b : L) Y = max(Y, b[2]);
    if (Y == 1)
        return res - 1;
    D = unboxed(M.toArray(new Integer[M.size()]));
    int R = 0;
    for (int i : rep(N)) {
        int T = calc(A[i][0], A[i][1]);
        R = max(R, T);
    }
    res += R;
    return res;
}