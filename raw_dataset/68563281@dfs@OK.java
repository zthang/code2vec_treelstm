void dfs(SumNode S, int V) {
    V += S.X;
    if (S.from + 1 == S.to) {
        if (Z != null && Z[2] == V)
            Z[1] = S.from;
        else
            L.add(Z = new int[] { S.from, S.from, V });
    } else {
        dfs(S.L, V);
        dfs(S.R, V);
    }
}