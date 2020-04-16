long dfs(int x, int par, int cx, int cp) {
    color[x] = cx;
    for (int y : edges[x]) for (int c = 0; c < 3; ++c) if (y != par && c != cx && c != cp) {
        return cost[x][cx] + dfs(y, x, c, cx);
    }
    return cost[x][cx];
}