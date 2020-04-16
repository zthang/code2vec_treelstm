static long rec(int idx, int c1, int c2) {
    if (idx < 1)
        return memo[idx][c1][c2] = 0;
    if (memo[perm[idx]][c1][c2] != -1)
        return memo[perm[idx]][c1][c2];
    long min = Long.MAX_VALUE;
    for (int i = 0; i < 3; i++) if (i != c1 && i != c2)
        min = Math.min(min, c[i][perm[idx]] + rec(idx - 1, i, c1));
    return memo[perm[idx]][c1][c2] = min;
}