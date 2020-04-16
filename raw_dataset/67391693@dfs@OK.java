int dfs(int depth, int i) {
    // < mod
    if (depth == 0) {
        if (scc())
            return 1;
        else
            return 0;
    }
    int sum = 0;
    for (int j = i; j < n; j++) {
        if (System.currentTimeMillis() - TIME_START >= 1500)
            return sum;
        flip(j);
        sum += dfs(depth - 1, j + 1);
        flip(j);
    }
    return sum;
}