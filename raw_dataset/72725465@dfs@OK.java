static void dfs(int x, int y, pair p) {
    for (int i = 0; i < 4; i++) {
        int X = x + op1[i], Y = y + op2[i];
        if (X < n && X >= 0 && Y < n && Y >= 0 && ans[X][Y] == '$' && a[X][Y].x == p.x && a[X][Y].y == p.y) {
            ans[X][Y] = lookup[i];
            dfs(X, Y, p);
        }
    }
}