public static void dfs(int x, int y, int cnt) {
    if (x == ex && y == ey) {
        book[cnt]++;
        // / System.out.println(1111);
        if (cnt < ans)
            ans = cnt;
        return;
    }
    // System.out.println(cnt + " " + x + " " + y);
    if (x < 0 || x > 29 || y < 0 || y > 49 || mp[x][y] == '1' || vis[x][y] == 1)
        return;
    vis[x][y] = 1;
    dfs(x, y + 1, cnt + 1);
    dfs(x + 1, y, cnt + 1);
    dfs(x, y - 1, cnt + 1);
    dfs(x - 1, y, cnt + 1);
    vis[x][y] = 0;
    // System.out.println(cnt + " " + x + " " + y);
    return;
}