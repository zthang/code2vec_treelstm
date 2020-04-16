private void dfs(int p, int q, char d) {
    if (mat[p][q] != '0')
        return;
    mat[p][q] = d;
    if (x[p][q] == x[p + 1][q] && y[p][q] == y[p + 1][q]) {
        dfs(p + 1, q, 'U');
    }
    if (x[p][q] == x[p - 1][q] && y[p][q] == y[p - 1][q]) {
        dfs(p - 1, q, 'D');
    }
    if (x[p][q] == x[p][q + 1] && y[p][q] == y[p][q + 1]) {
        dfs(p, q + 1, 'L');
    }
    if (x[p][q] == x[p][q - 1] && y[p][q] == y[p][q - 1]) {
        dfs(p, q - 1, 'R');
    }
}