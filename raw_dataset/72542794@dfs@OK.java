static boolean dfs(int r, int c, char x) {
    if (ans[r][c] != '-')
        return false;
    ans[r][c] = x;
    vis[r][c] = true;
    for (int i = 0; i < 4; i++) {
        int newR = dirR[i] + r;
        int newC = dirC[i] + c;
        if (isValid(newR, newC) && !vis[newR][newC] && p[newR][newC].equals(tmp)) {
            char y = res(newR, newC, r, c);
            if (!dfs(newR, newC, y))
                return false;
        }
    }
    return true;
}