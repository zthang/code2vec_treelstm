private long solve(int x, int y) {
    visited = new boolean[n + 1];
    visited[y] = true;
    dfs(x);
    long p = n - 1 - count;
    count = 0;
    visited = new boolean[n + 1];
    visited[x] = true;
    dfs(y);
    long q = n - 1 - count;
    count = 0;
    return p * q;
}