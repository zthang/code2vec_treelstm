void dfs(SumNode S, int V) {
    V += S.X;
    if (S.from + 1 == S.to)
        B.add(new int[] { S.from, S.from, V });
    else {
        dfs(S.L, V);
        dfs(S.R, V);
    }
}